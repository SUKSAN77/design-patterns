package iterator

import collection.ItemCollection
import items.Item

class AllIterator(itemColl: ItemCollection<Item>) : Iterator<Item> {
    private val items: List<Item> = itemColl.getItems()
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