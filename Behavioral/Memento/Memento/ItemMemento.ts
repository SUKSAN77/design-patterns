import { Memento } from "./Memento";
import { Attribute, ItemType } from "../type";

export class ItemMemento implements Memento {
  private name: string;
  private type: ItemType;
  private rarity: string;
  private level: number;
  private value: number;
  private attackPower: number;
  private attributes: Attribute[];

  constructor(
    name: string,
    type: ItemType,
    rarity: string,
    level: number,
    value: number,
    attackPower: number,
    attributes: Attribute[]
  ) {
    this.name = name;
    this.type = type;
    this.rarity = rarity;
    this.level = level;
    this.value = value;
    this.attackPower = attackPower;
    this.attributes = [...attributes]; // Clone the attributes array // Spread Operator
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
}
