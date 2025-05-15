package iterator

import collection.ItemCollection
import items.Item
import items.Rarity

class CommonIterator(itemColl: ItemCollection<Item>) : Iterator<Item> {
    //    private val items: MutableList<Item> = mutableListOf()
    private val items: List<Item> = itemColl.getItems().filter { it.getRarity() == Rarity.COMMON }
    private var curIndex = 0
//    private var endIndex = 0

//    init {
//        var j = 0
//        for (i in 0 until itemColl.getSizeCollection()) {
//            val itemTemp = itemColl.getIndex(i)
//            itemTemp.toString().lowercase()
//            if (itemTemp.getRarity() == "common") {
//                items.add(itemTemp)
//                j++
//            }
//        }
//        endIndex = j
//        curIndex = 0
//    }

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