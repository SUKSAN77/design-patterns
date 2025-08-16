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
      const previous = this.history[this.history.length - 1];
      if (previous) {
        previous.restore();
      } else {
        console.log("⚠️ Cannot restore state");
      }
    } else {
      console.log("⚠️ Cannot undo anymore");
    }
  }

  getHistory(): Memento[] {
    return this.history;
  }
  showHistoryData() {
    this.history.forEach((memento, index) => {
      console.log(`\n🔄 History ${index + 1}:`);
      memento.showInfo();
    });
  }
}

