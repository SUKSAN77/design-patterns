package org.example.com.leaf

import org.example.com.compontent.ItemComponent

open class Item(protected val name: String) : ItemComponent {
    override var parent: ItemComponent? = null

    override fun getRandomItem(): String {
        return name
    }

    override fun displayItems() {
        println("Item: $name")
    }
}