package org.example

import org.example.com.monster.Dragon
import org.example.com.monster.Golem
import org.example.com.monster.Monster
import org.example.com.player.Player
import org.example.com.player.PlayerStatus

fun client(player: PlayerStatus, monster: Monster): PlayerStatus {
    println("🔥 Battle Start: ${player.descriptionBuff()} vs ${monster.name}")

    if (player.attackPower >= monster.hp) {
        println("💀 ${monster.name} Killed!")
        return monster.grantBuff(player)
    } else {
        println("❌ ${monster.name} not Die! more attack!")
        return player
    }
}


fun main() {
    println("========= Create Player =========")
    val newPlayer: PlayerStatus = Player("SUKSAN", 1200.0, 50.0)
    newPlayer.showStatus()
    println("=================================")
    println("Let's Fight Golem for The HpBuff")
    val stoneGolem = Golem("StoneGolem")
    val newPlayerWithHPBuff = client(newPlayer, stoneGolem)
    println("========= Player Status =========")
    newPlayerWithHPBuff.showStatus()
    println(newPlayerWithHPBuff.descriptionBuff())
    println("=================================")

    println("Let's Fight Dragon for The DmgBuff")
    val fireDragon = Dragon("FireDragon", buffDmg = 100)
    val newPlayerWithHPBuffWithDmgBuff = client(newPlayerWithHPBuff, fireDragon)
    println("========= Player Status =========")
    newPlayerWithHPBuffWithDmgBuff.showStatus()
    println(newPlayerWithHPBuffWithDmgBuff.descriptionBuff())
    println("=================================")

}