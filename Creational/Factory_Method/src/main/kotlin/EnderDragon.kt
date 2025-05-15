package org.example

class EnderDragon : BaseMonster {

    override fun attack() {
        println("Attacks with tail!!")
    }

    override fun move() {
        println("Fly searching for player")
    }

    override fun spacialAttack() {
        println("Sprays fire at the player!!")
    }
}