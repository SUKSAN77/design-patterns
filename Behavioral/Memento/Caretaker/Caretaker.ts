import { Memento } from "../Memento/Memento";
import { Originator } from "../Originator/Originator";

export class Caretaker<T> {
  private history: Memento<T>[] = [];
  private originator: Originator<T>;

  constructor(originator: Originator<T>) {
    this.originator = originator;
    this.addHistory(); // Save initial state
  }

  addHistory() {
    this.history.push(this.originator.saveMemento());
  }

  undo() {
    if (this.history.length > 1) {
      this.history.pop(); // Remove current state
      this.originator.restoreMemento(this.history[this.history.length - 1]); // Restore last state
    } else {
      console.log("⚠️ Cannot undo anymore");
    }
  }

  getHistory(): Memento<T>[] {
    return this.history;
  }
}
