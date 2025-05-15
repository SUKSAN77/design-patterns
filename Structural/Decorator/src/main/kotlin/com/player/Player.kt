package org.example.com.player

class Player(
    override val name: String = "player",
    override val attackPower: Double = 10.0,
    override val maxHp: Double = 100.0
) : PlayerStatus {
    override fun descriptionBuff() = name
    override fun showStatus() {
        println("Player : $name")
        println("MaxHp : $maxHp")
        println("Dmg : $attackPower")
    }
}