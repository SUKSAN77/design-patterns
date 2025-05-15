package org.example.com.decorator

import org.example.com.player.PlayerStatus

class DmgBuffDecorator(playerStatus: PlayerStatus, private val extraDmg: Int = 5) : BuffDecorator(playerStatus) {
    override val attackPower: Double get() {
        return super.attackPower + extraDmg
    }
    override fun descriptionBuff() = super.descriptionBuff() + " (Attack Buff +$extraDmg)"
}