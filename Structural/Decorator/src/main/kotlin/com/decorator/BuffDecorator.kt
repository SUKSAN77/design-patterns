package org.example.com.decorator

import org.example.com.player.PlayerStatus

abstract class BuffDecorator(private val decoratedPlayerStatus: PlayerStatus) : PlayerStatus {
    override val name: String = decoratedPlayerStatus.name
    override val attackPower: Double get() = decoratedPlayerStatus.attackPower
    override val maxHp: Double get() = decoratedPlayerStatus.maxHp
    override fun descriptionBuff(): String {
        return  decoratedPlayerStatus.descriptionBuff()
    }
    override fun showStatus() {
        println("Player : $name")
        println("MaxHp : $maxHp")
        println("Dmg : $attackPower")
    }
}
