package org.example

import org.example.com.handler.*
import org.example.com.player.Player
import org.example.com.player.SkillData
import org.example.com.player.SkillSystem

fun main() {
    val player = Player(
        name = "SUKSAN EIEI",
        mana = 50,
        distanceToEnemy = 5.0,
        hasBuff = true,
        isStunned = false
    )

    val fireball = SkillData("Fireball", manaCost = 20, cooldown = 5000, range = 10.0)
    val lightning = SkillData("Lightning", manaCost = 30, cooldown = 3000, range = 3.0)

//Handler (Stun → Mana → Cooldown → Range)
    val stunHandler = StunHandler()
    val manaHandler = ManaHandler()
    val cooldownHandler = CooldownHandler()
    val rangeHandler = RangeHandler()

    stunHandler.setNext(manaHandler).setNext(cooldownHandler).setNext(rangeHandler)

    val skillSystem = SkillSystem(stunHandler)

    println("\nFirst Cast (Everything OK):")
    skillSystem.useSkill(player, fireball)  //ใช้ได้

    println("\nCast Again (Cooldown Not Ready):")
    skillSystem.useSkill(player, fireball)  //คูลดาวน์

    println("\nCast Lightning (Out of Range):")
    player.distanceToEnemy = 4.0 // ขยับออกห่างเกินระยะสกิล
    skillSystem.useSkill(player, lightning) //อยู่ไกลเกินไป

    println("\nPlayer is Stunned (Cannot Cast):")
    player.isStunned = true
    skillSystem.useSkill(player, fireball)  //ติดStun

    println("\nRemove Stun & Cast Fireball Again:")
    player.isStunned = false
    skillSystem.useSkill(player, fireball)  //ใช้ได้

}