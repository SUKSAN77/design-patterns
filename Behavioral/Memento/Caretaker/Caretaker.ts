import { Memento } from "../Memento/Memento";
import { Originator } from "../Originator/Originator";

export class Caretaker {
  private history: Memento[] = [];
  private originator: Originator;

  constructor(originator: Originator) {
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

  getHistory(): Memento[] {
    return this.history;
  }
}
