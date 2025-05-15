import Command from "../interface/Command";
import Unit from "../Receiver/Unit";

class AttackCommand implements Command {
  constructor(private unit: Unit, private target: Unit) {}

  execute() {
    this.unit.attack(this.target);
  }

  undo() {
    console.log(`${this.unit.getName()} stopped attacking ${this.target.getName()}!`);
  }
}
export default AttackCommand;
// เมื่อ execute → ยูนิตจะทำการโจมตีเป้าหมาย
// เมื่อ undo → ยูนิตจะหยุดการโจมตี