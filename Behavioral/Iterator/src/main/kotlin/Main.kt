import collection.ArmorCollection
import collection.WeaponCollection
import items.Armor
import items.Item
import items.Rarity
import items.Weapon
import iterator.Iterator

fun showItems(iterator: Iterator<Item>) {
    while (iterator.hasNext()) {
        iterator.next()?.showItemDetail()
    }
}

fun main() {

    val weapons = listOf(
        Weapon("Sword", "SwordDragon", Rarity.LEGENDARY, 2.5, 35.00),
        Weapon("Dagger", "Dagger", Rarity.COMMON, 45.5, 15.00),
        Weapon("LongSword", "Sword of Magnus", Rarity.EPIC, 0.5, 55.00),
        Weapon("Katana", "Shimura", Rarity.COMMON, 10.5, 45.00),
        Weapon("Axe", "Warrior's Axe", Rarity.LEGENDARY, 30.0, 50.00),
        Weapon("Bow", "Elven Bow", Rarity.EPIC, 15.0, 5.00),
        Weapon("Crossbow", "Dragon Slayer Crossbow", Rarity.EPIC, 12.5, 8.00),
        Weapon("Mace", "Hammer of Justice", Rarity.LEGENDARY, 40.0, 25.00),
        Weapon("Spear", "Spear of the Sea", Rarity.COMMON, 20.0, 7.00),
        Weapon("Club", "Giant's Club", Rarity.COMMON, 50.0, 60.00)
    )

    val armors = listOf(
        Armor("Helmet", "Pirate Helmet", Rarity.COMMON, 10.0, 5.0),
        Armor("Chestplate", "Pirate Chestplate", Rarity.COMMON, 20.0, 5.0),
        Armor("Leggings", "Pirate Leggings", Rarity.COMMON, 15.0, 3.0),
        Armor("Boots", "Pirate Boots", Rarity.COMMON, 8.0, 10.0),
        Armor("Helmet", "Knight Helmet", Rarity.EPIC, 25.0, 10.0),
        Armor("Chestplate", "Knight Chestplate", Rarity.EPIC, 40.0, 8.0),
        Armor("Leggings", "Knight Leggings", Rarity.EPIC, 30.0, 6.0),
        Armor("Boots", "Knight Boots", Rarity.EPIC, 18.0, 12.0),
        Armor("Helmet", "Dragon Helmet", Rarity.LEGENDARY, 50.0, 15.0),
        Armor("Chestplate", "Dragon Chestplate", Rarity.LEGENDARY, 60.0, 12.0)
    )
    val weaponBox = WeaponCollection()
    weapons.forEach { weaponBox.add(it) }
//    weapons.forEach { weaponBox.remove(it) }

    println("🛡️✨ Weapon Collection ✨🛡️")
    showItems(weaponBox.createIterator())
    println("───────────────────────")
    println("🛡️✨ Weapon Common ✨🛡️")
    showItems(weaponBox.createCommonIterator())
    println("───────────────────────")


    val armorBox = ArmorCollection()
    armors.forEach { armorBox.add(it) }
    println("🛡️✨ Armor Collection ✨🛡️")
    showItems(armorBox.createIterator())
    println("───────────────────────")
    println("🛡️✨ Armor Legendary ✨🛡️")
    showItems(armorBox.createLegendaryIterator())
    println("───────────────────────")
    println("🛡️✨ Armor Epic ✨🛡️")
    showItems(armorBox.createEpicItemsIterator())
    println("───────────────────────")


}