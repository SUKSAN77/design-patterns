package org.example.com.decorator

import org.example.com.player.PlayerStatus

class HpBuffDecorator(playerStatus: PlayerStatus, private val extraHp: Int = 20) : BuffDecorator(playerStatus) {
    override val maxHp: Double get() = super.maxHp + extraHp
    override fun descriptionBuff() = super.descriptionBuff() + " (Health Buff +$extraHp)"
}