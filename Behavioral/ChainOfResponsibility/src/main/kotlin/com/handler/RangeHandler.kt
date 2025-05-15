package org.example.com.handler

import org.example.com.player.Player
import org.example.com.player.SkillData

class RangeHandler : Skill() {
    override fun process(player: Player, skill: SkillData): Boolean {
        return if (player.distanceToEnemy <= skill.range) {
            println("Target in range for ${skill.name}")
            true
        } else {
            println("Target is too far for ${skill.name}!")
            false
        }
    }
}