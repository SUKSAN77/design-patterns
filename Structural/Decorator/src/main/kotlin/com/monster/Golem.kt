package org.example.com.monster

import org.example.com.decorator.HpBuffDecorator
import org.example.com.player.PlayerStatus

class Golem(
    override val name: String = "Golem",
    override val hp: Int = 80,
    override val damage: Int = 5,
    private val buffHp: Int = 20
) : Monster {
    override fun grantBuff(player: PlayerStatus): PlayerStatus {
        println("$name defeated! Player received Health Buff (+$buffHp)!")
        return HpBuffDecorator(player, buffHp)
    }
}