package org.example

import org.example.com.effect.*
import org.example.com.weapon.*

fun main() {
    val fireEffect = FireEffect()
    val frostEffects = FrostEffect()
    val thunderEffect = ThunderEffect()

    println("---------------------------------------------------------")
    val longSword = Sword(1, 25.5)
    longSword.attack("SUKSAN")
    longSword.enchanted(frostEffects)
    longSword.attack("SUKSAN")
    println("---------------------------------------------------------")
    val axe = Axe(2, 30.0)
    axe.attack("Monster")
    axe.enchanted(thunderEffect)
    axe.attack("Monster")
    println("---------------try to enchant same Effect----------------")
    axe.enchanted(thunderEffect)
    axe.attack("Monster2")
    println("---------------------------------------------------------")
    val spear = Spear(2, 30.0, fireEffect)
    spear.attack("Demon")
    println("---------------------------------------------------------")
}