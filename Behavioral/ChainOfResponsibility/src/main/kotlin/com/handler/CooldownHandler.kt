package org.example.com.handler

import org.example.com.player.Player
import org.example.com.player.SkillData

class CooldownHandler : Skill() {
    override fun process(player: Player, skill: SkillData): Boolean {
        val currentTime = System.currentTimeMillis()
        return if (currentTime - skill.lastUsedTime >= skill.cooldown) {
            println("✅ Cooldown OK for ${skill.name}")
            true
        } else {
            println("⏳ ${skill.name} is on cooldown!")
            false
        }
    }
}
