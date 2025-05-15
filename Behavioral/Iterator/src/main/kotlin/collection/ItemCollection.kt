package collection

import items.Item
import iterator.Iterator

interface ItemCollection<T> {
    fun createIterator(): Iterator<Item>
    fun createCommonIterator(): Iterator<Item>
    fun createLegendaryIterator(): Iterator<Item>
    fun createEpicItemsIterator(): Iterator<Item>
    fun getIndex(index: Int): T
    fun getSizeCollection(): Int
    fun getItems(): List<T>
}