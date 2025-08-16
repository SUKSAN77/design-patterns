import { Memento } from "../Memento/Memento";
import { ItemMemento } from "../Memento/ItemMemento";
import { Originator } from "./Originator";
import { Attribute, AttributeType, ItemType } from "../type";

export abstract class ItemOriginator implements Originator {
  protected name: string;
  protected type: ItemType;
  protected rarity: string;
  protected value: number;
  protected level: number = 1;
  protected attackPower: number = 0;
  protected attributes: Attribute[] = [];

  constructor(
    name: string,
    type: ItemType,
    rarity: string,
    value: number,
    attackPower: number
  ) {
    this.name = name;
    this.type = type;
    this.rarity = rarity;
    this.value = value;
    this.attackPower = attackPower;
  }

  saveMemento(): Memento {
    return new ItemMemento(
      this,
      this.name,
      this.type,
      this.rarity,
      this.value,
      this.level,
      this.attackPower,
      this.attributes
    );
  }

  setStateMemento(
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
    this.attributes = attributes.map(attr => ({ ...attr }));
    this.updateAttributes();
  }

  getAttackPower(): number {
    return this.attackPower;
  }

  getAttributes(): Attribute[] {
    return this.attributes;
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

  getLevel(): number {
    return this.level;
  }

  getValue(): number {
    return this.value;
  }

  abstract setLevel(level: number): void;

  protected generateRandomAttribute(): Attribute {
    const attributeList: AttributeType[] = [
      AttributeType.FireDamage,
      AttributeType.IceDamage,
      AttributeType.PoisonDamage,
      AttributeType.CriticalChance,
    ];

    const randomType =
      attributeList[Math.floor(Math.random() * attributeList.length)];

    const rarityMultiplier = this.getRarityMultiplier();
    const baseValue = this.level * rarityMultiplier;
    let bonusDamage = Math.round(baseValue * (1 + Math.random() * 0.5));

    let description = "";
    switch (randomType) {
      case AttributeType.FireDamage:
        description = `Adds ${bonusDamage} fire damage`;
        break;
      case AttributeType.IceDamage:
        description = `Adds ${bonusDamage} ice damage`;
        break;
      case AttributeType.PoisonDamage:
        description = `Adds ${bonusDamage} poison damage`;
        break;
      case AttributeType.CriticalChance:
        bonusDamage = Math.min(20, Math.round(baseValue / 2)); // Cap at 20%
        description = `Increases critical hit chance by ${bonusDamage}%`;
        break;
    }

    return { type: randomType, bonusDamage, description };
  }

  private getRarityMultiplier(): number {
    switch (this.rarity) {
      case "Common":
        return 1;
      case "Uncommon":
        return 1.5;
      case "Rare":
        return 2;
      case "Epic":
        return 3;
      case "Legendary":
        return 5;
      default:
        return 1;
    }
  }

  protected updateAttributes() {
    if (this.level < 5) {
      if (this.attributes.length > 0) {
        console.log(`🔮 Attributes lost as level fell below 5`);
        this.attributes = [];
      }
      return;
    }

    if (this.level >= 5 && this.attributes.length === 0) {
      const attribute = this.generateRandomAttribute();
      this.attributes.push(attribute);
      console.log(
        `🔮 New attribute unlocked at level 5: ${attribute.description}`
      );
    }

    if (this.level >= 8 && this.attributes.length === 1) {
      let newAttribute: Attribute;
      do {
        newAttribute = this.generateRandomAttribute();
      } while (newAttribute.type === this.attributes[0].type);

      this.attributes.push(newAttribute);
      console.log(
        `🔮 Second attribute unlocked at level 8: ${newAttribute.description}`
      );
    }

    if (this.level < 8 && this.attributes.length > 1) {
      const removedAttribute = this.attributes.pop();
      console.log(
        `🔮 Lost second attribute as level fell below 8: ${removedAttribute?.description}`
      );
    }
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
