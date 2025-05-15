import Command from "../interface/Command";
import Unit from "../Receiver/Unit";

class BuildUnitCommand implements Command {
    private builtUnit: Unit | null = null;
  
    constructor(private unitName: string, private position: { x: number; y: number }) {}
  
    execute() {
      this.builtUnit = new Unit(this.unitName, this.position);
      console.log(`Built new unit: ${this.builtUnit.getName()} at (${this.position.x}, ${this.position.y})`);
    }
  
    undo() {
      if (this.builtUnit) {
        console.log(`Removing unit: ${this.builtUnit.getName()}`);
        this.builtUnit = null;
      }
    }
  }
export default BuildUnitCommand;