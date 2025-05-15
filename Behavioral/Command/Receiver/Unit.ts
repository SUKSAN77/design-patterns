class Unit {
  constructor(
    private name: string,
    private position: { x: number; y: number }
  ) {}

  move(x: number, y: number) {
    console.log(`${this.name} moved to (${x}, ${y})`);
    this.position = { x, y };
  }

  attack(target: Unit) {
    console.log(`${this.name} attacks ${target.name}!`);
  }

  defend() {
    console.log(`${this.name} is defending!`);
  }

  stop() {
    console.log(`${this.name} stopped.`);
  }

  getName(): string {
    return this.name;
  }
}
export default Unit;
// ยูนิตมีคุณสมบัติดังนี้:
// ชื่อ (name) และตำแหน่ง (position) ที่มีค่าเป็น { x: number; y: number }