package org.example.com.handler

import org.example.com.player.Player
import org.example.com.player.SkillData

class BuffHandler : Skill() {
    override fun process(player: Player, skill: SkillData): Boolean {
        return if (player.hasBuff) {
            println("Buff detected! Skill ${skill.name} is powered up!")
            true
        } else {
            println("No buff, normal skill usage for ${skill.name}")
            false
        }
    }
}
