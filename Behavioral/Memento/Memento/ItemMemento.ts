import { Memento } from "./Memento";
import { Attribute, ItemType } from "../type";
import { ItemOriginator } from "../Originator/ItemOriginator";

export class ItemMemento implements Memento {
  private originator: ItemOriginator;
  private name: string;
  private type: ItemType;
  private rarity: string;
  private value: number;
  private level: number = 1;
  private attackPower: number = 0;
  private attributes: Attribute[] = [];

  constructor(
    originator: ItemOriginator,
    name: string,
    type: ItemType,
    rarity: string,
    value: number,
    level: number,
    attackPower: number,
    attributes: Attribute[]
  ) {
    this.originator = originator;
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

  restore() {
    this.originator.setStateMemento(
      this.name,
      this.type,
      this.rarity,
      this.value,
      this.level,
      this.attackPower,
      this.attributes
    );
  }

   showInfo() {
    console.log(
      `🏹 Name: ${this.getName()} | Type: ${this.getType()} | Rarity: ${this.getRarity()} | Level: ${this.getLevel()} | Value: ${this.getValue()} | Attack: ${this.getAttackPower()}`
    );

    if (this.attributes.length > 0) {
      console.log("✨ Attributes:");
      this.attributes.forEach((attr, index) => {
        console.log(` ${index + 1}. ${attr.description}`);
      });
    }
  }
}
