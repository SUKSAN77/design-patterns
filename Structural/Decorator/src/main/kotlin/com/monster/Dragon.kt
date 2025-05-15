package org.example.com.monster

import org.example.com.decorator.DmgBuffDecorator
import org.example.com.player.PlayerStatus

class Dragon(
    override val name: String = "Dragon",
    override val hp: Int = 50,
    override val damage: Int = 10,
    private val buffDmg: Int = 5
) : Monster {
    override fun grantBuff(player: PlayerStatus): PlayerStatus {
        println("$name defeated! Player received Attack Buff (+$buffDmg)!")
        return DmgBuffDecorator(player, buffDmg)
    }
}