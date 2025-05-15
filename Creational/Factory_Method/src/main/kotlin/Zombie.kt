package org.example

class Zombie : BaseMonster {

    override fun attack() {
        println("Bite the player!!")
    }

    override fun move() {
        println("Walk towards find the player")
    }

    override fun spacialAttack() {
        println("Rushes towards the player")
    }
}