package org.example.com.compontent

interface ItemComponent {
    var parent: ItemComponent?
    fun addParent(parent: ItemComponent) {
        this.parent = parent
    }

    fun getRandomItem(): String
    fun displayItems()
    fun getParent(): String {
        return this.parent.toString()
    }
}
