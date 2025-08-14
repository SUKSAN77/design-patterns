import { Memento } from "./Memento";
import { Attribute, ItemType } from "../type";

export interface ItemState {
  name: string;
  type: ItemType;
  rarity: string;
  level: number;
  value: number;
  attackPower: number;
  attributes: Attribute[];
}

export class ItemMemento implements Memento<ItemState> {
  private state: ItemState;

  constructor(state: ItemState) {
    this.state = {
      name: state.name,
      type: state.type,
      rarity: state.rarity,
      level: state.level,
      value: state.value,
      attackPower: state.attackPower,
      attributes: [...state.attributes],
    };
  }

  getLevel(): number {
    return this.state.level;
  }

  getName(): string {
    return this.state.name;
  }

  getType(): ItemType {
    return this.state.type;
  }

  getRarity(): string {
    return this.state.rarity;
  }

  getValue(): number {
    return this.state.value;
  }

  getAttackPower(): number {
    return this.state.attackPower;
  }

  getAttributes(): Attribute[] {
    return [...this.state.attributes]; // Return a copy to prevent modification
  }

  getState(): ItemState {
    return {
      name: this.state.name,
      type: this.state.type,
      rarity: this.state.rarity,
      level: this.state.level,
      value: this.state.value,
      attackPower: this.state.attackPower,
      attributes: [...this.state.attributes],
    };
  }

  setState(state: ItemState): void {
    this.state = {
      name: state.name,
      type: state.type,
      rarity: state.rarity,
      level: state.level,
      value: state.value,
      attackPower: state.attackPower,
      attributes: [...state.attributes],
    };
  }
}
