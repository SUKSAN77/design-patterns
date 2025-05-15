package org.example.com.handler

import org.example.com.player.Player
import org.example.com.player.SkillData

class StunHandler : Skill() {
    override fun process(player: Player, skill: SkillData): Boolean {
        return if (!player.isStunned) {
            println("Player is not stunned, can use ${skill.name}")
            true
        } else {
            println("Player is stunned! Cannot use ${skill.name}!")
            false
        }
    }
}
