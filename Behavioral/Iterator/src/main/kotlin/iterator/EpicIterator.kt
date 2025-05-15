package iterator

import collection.ItemCollection
import items.Item
import items.Rarity

class EpicIterator(itemColl: ItemCollection<Item>) : Iterator<Item> {
    private val items: List<Item> = itemColl.getItems().filter { it.getRarity() == Rarity.EPIC }
    private var curIndex = 0

    init {
        if (items.isEmpty()) {
            println("Empty")
        }
    }

    override fun next(): Item {
        if (!hasNext()) throw NoSuchElementException("No more items")
        return items[curIndex++]
    }

    override fun hasNext(): Boolean {
        return curIndex < items.size
    }

}