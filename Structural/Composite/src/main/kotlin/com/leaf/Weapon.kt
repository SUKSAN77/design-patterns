package org.example.com.leaf

class Weapon(name: String) : Item(name) {
    override fun displayItems() {
        println("Weapon: $name")
    }
}