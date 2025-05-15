package org.example.com.composite

import org.example.com.compontent.ItemComponent

class ItemBox(private val nameBox: String) : ItemComponent {
    private val items = mutableListOf<ItemComponent>()

    override var parent: ItemComponent? = null

    fun add(item: ItemComponent) {
        items.add(item)
        item.addParent(this)
    }

    override fun getRandomItem(): String {
        if (items.isEmpty()) return "Empty Box"
        return items.random().getRandomItem()
    }

    override fun displayItems() {
        println("----------Item in $nameBox----------")
        items.forEach { it.displayItems() }
    }
}