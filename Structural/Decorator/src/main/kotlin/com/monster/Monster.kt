package org.example.com.monster

import org.example.com.player.PlayerStatus

interface Monster {
    val name: String
    val hp: Int
    val damage: Int
    fun grantBuff(player: PlayerStatus): PlayerStatus
}