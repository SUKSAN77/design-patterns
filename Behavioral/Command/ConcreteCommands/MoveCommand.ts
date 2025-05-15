import Command from "../interface/Command";
import Unit from "../Receiver/Unit";

class MoveCommand implements Command {
    private previousPosition: { x: number; y: number };
  
    constructor(private unit: Unit, private x: number, private y: number) {
      this.previousPosition = { ...unit["position"] };
    }
  
    execute() {
      this.unit.move(this.x, this.y);
    }
  
    undo() {
      this.unit.move(this.previousPosition.x, this.previousPosition.y);
    }
  }
export default MoveCommand;
// ก่อนเคลื่อนที่ (ก่อน execute) → บันทึกตำแหน่งเก่าของยูนิตลงใน previousPosition
// เมื่อ execute → ยูนิตถูกย้ายไปตำแหน่งใหม่ (x, y)
// เมื่อ undo → ยูนิตจะถูกย้ายกลับไปยัง previousPosition