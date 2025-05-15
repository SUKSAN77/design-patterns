import { Item } from "./Item";
import { ItemType } from "../type";

export class Bow extends Item {
  constructor(name: string, rarity: string, value: number) {
    super(name, ItemType.Bow, rarity, value, 40);
  }

  setLevel(level: number) {
    this.level = level;
    this.value = Math.round(this.value * 1.2); // Increase value by 20%
    this.attackPower = Math.round(this.attackPower * 1.12); // Increase attack power by 12%
    this.updateAttributes();
  }
}
