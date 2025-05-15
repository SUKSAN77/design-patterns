package org.example

interface CharacterVisitor {
    fun visitWarrior(warrior: Warrior)
    fun visitMage(mage: Mage)
    fun visitArcher(archer: Archer)
}
