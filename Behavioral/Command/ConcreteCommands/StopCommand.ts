import Command from "../interface/Command";
import Unit from "../Receiver/Unit";

class StopCommand implements Command {
    constructor(private unit: Unit) {}
  
    execute() {
      this.unit.stop();
    }
  
    undo() {
      console.log(`Can't undo StopCommand.`);
    }
  }
export default StopCommand;
// เมื่อ execute → ยูนิตจะหยุดการกระทำทุกอย่าง
// เมื่อ undo → ไม่สามารถย้อนกลับได้