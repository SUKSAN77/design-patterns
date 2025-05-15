import { Attribute, ItemType } from "../type";

export interface Memento {
    getName(): string;
    getType(): ItemType;
    getRarity(): string;
    getLevel(): number;
    getValue(): number;
    getAttackPower(): number;
    getAttributes(): Attribute[];
  }