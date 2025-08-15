import { Memento } from "./Memento";
import { Attribute, ItemType } from "../type";

export class ItemMemento implements Memento {
  private name: string;
  private type: ItemType;
  private rarity: string;
  private value: number;
  private level: number = 1;
  private attackPower: number = 0;
  private attributes: Attribute[] = [];

  constructor(
    name: string,
    type: ItemType,
    rarity: string,
    value: number,
    level: number,
    attackPower: number,
    attributes: Attribute[]
  ) {
    this.name = name;
    this.type = type;
    this.rarity = rarity;
    this.value = value;
    this.level = level;
    this.attackPower = attackPower;
    this.attributes = attributes;
  }

  getLevel(): number {
    return this.level;
  }

  getName(): string {
    return this.name;
  }

  getType(): ItemType {
    return this.type;
  }

  getRarity(): string {
    return this.rarity;
  }

  getValue(): number {
    return this.value;
  }

  getAttackPower(): number {
    return this.attackPower;
  }

  getAttributes(): Attribute[] {
    return [...this.attributes]; // Return a copy to prevent modification
  }

  getSnapshot() {
    return {
      name: this.name,
      type: this.type,
      rarity: this.rarity,
      level: this.level,
      value: this.value,
      attackPower: this.attackPower,
      attributes: [...this.attributes],
    };
  }
}
