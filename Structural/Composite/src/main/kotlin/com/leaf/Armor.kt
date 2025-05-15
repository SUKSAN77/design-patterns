package org.example.com.leaf

class Armor(name: String) : Item(name) {
    override fun displayItems() {
        println("Armor: $name")
    }
}