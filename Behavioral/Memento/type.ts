export enum ItemType {
  Sword = "Sword",
  Bow = "Bow",
}

export enum AttributeType {
  FireDamage = "FireDamage",
  IceDamage = "IceDamage",
  PoisonDamage = "PoisonDamage",
  CriticalChance = "CriticalChance",
}

export interface Attribute {
  type: AttributeType;
  bonusDamage: number;
  description: string;
}


