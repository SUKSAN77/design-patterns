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
      this.history.pop(); // ลบสถานะปัจจุบัน
      this.originator.restoreMemento(this.history[this.history.length - 1]); // ใช้สถานะล่าสุดที่เหลือ // last index 
    } else {
      console.log("⚠️ Cannot undo anymore");
    }
  }
}
