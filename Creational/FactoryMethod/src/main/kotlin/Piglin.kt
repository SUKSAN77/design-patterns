package org.example

class Piglin : BaseMonster {
    override fun attack() {
        println("Attack with an axe!!")
    }

    override fun move() {
        println("Looking for players")
    }

    override fun spacialAttack() {
        println("Throwing axe")
    }
}