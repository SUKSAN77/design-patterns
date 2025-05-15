import Command from "../interface/Command";
import Unit from "../Receiver/Unit";

class DefendCommand implements Command {
    constructor(private unit: Unit) {}
  
    execute() {
      this.unit.defend();
    }
  
    undo() {
      console.log(`${this.unit.getName()} stops defending.`);
    }
  }

  
export default DefendCommand;
// เมื่อ execute → ยูนิตจะทำการป้องกัน
// เมื่อ undo → ยูนิตจะหยุดการป้องกัน