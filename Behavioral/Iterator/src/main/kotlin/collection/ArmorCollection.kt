package collection

import items.Armor
import items.Item
import iterator.*
import iterator.Iterator

class ArmorCollection : ItemCollection<Item> {

    private val armors = mutableListOf<Item>()

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

    fun add(armor: Armor) {
        armors.add(armor)
    }

    override fun getIndex(index: Int): Item {
        return armors[index]
    }

    override fun getSizeCollection(): Int {
        return armors.size
    }

    override fun getItems(): List<Item> {
        return List(getSizeCollection()) { i -> getIndex(i) }
    }

}