import { Item } from "./Item";
import { ItemType } from "../type";

export class Sword extends Item {
  constructor(name: string, rarity: string, value: number) {
    super(name, ItemType.Sword, rarity, value, 50);
  }

  setLevel(level: number) {
    this.level = level;
    this.value = Math.round(this.value * 1.2); // Increase value by 20%
    this.attackPower = Math.round(this.attackPower * 1.15); // Increase attack power by 15%
    this.updateAttributes();
  }
}
