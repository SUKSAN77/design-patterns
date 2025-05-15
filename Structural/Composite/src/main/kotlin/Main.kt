package org.example

import org.example.com.compontent.ItemComponent
import org.example.com.composite.ItemBox
import org.example.com.leaf.Item
import org.example.com.leaf.Armor
import org.example.com.leaf.Weapon

fun randomBox(box: ItemComponent) {
    val reward = box.getRandomItem()
    println("This Random Reward item : $reward")
}

fun main() {
    val artifact = Item("ArtifactAnomaly")
    val sword = Weapon("LongSword")
    val shield = Armor("Diamond Shield")
    val helmet = Armor("Gold Helmet")

    val smallBox = ItemBox("SmallBox")
    smallBox.add(sword)
    smallBox.add(shield)
    smallBox.add(helmet)

    val bigBox = ItemBox("BigBox")
    bigBox.add(artifact)
    bigBox.add(smallBox)

    println("--------Display Item All in Box--------")
    bigBox.displayItems()
    println("--------Try Random Items--------")
    randomBox(bigBox)
    println("--------Show Parent Items--------")
    println("Parent of Sword: ${sword.getParent()}")
    println("Parent of Helmet: ${helmet.getParent()}")

}