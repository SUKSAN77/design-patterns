package collection

import items.Item
import items.Weapon
import iterator.*
import iterator.Iterator

class WeaponCollection : ItemCollection<Item> {

    private val weapons = mutableListOf<Item>()

    override fun createIterator(): Iterator<Item> {
        return AllIterator(this)
    }

    override fun createCommonIterator(): Iterator<Item> {
        return CommonIterator(this)
    }

    override fun createEpicItemsIterator(): Iterator<Item> {
        return EpicIterator(this)
    }

    override fun createLegendaryIterator(): Iterator<Item> {
        return LegendaryIterator(this)
    }


    fun add(weapon: Weapon) {
        weapons.add(weapon)
    }

    fun remove(weapon: Weapon){
        weapons.remove(weapon)
    }

    override fun getIndex(index: Int): Item {
        return weapons[index]
    }

    override fun getSizeCollection(): Int {
        return weapons.size
    }

    override fun getItems(): List<Item> {
        return List(getSizeCollection()) { i -> getIndex(i) }
    }

}