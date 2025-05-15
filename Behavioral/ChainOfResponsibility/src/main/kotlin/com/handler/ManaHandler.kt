package org.example.com.handler

import org.example.com.player.Player
import org.example.com.player.SkillData

class ManaHandler : Skill() {
    override fun process(player: Player, skill: SkillData): Boolean {
        return if (player.mana >= skill.manaCost) {
            println("Use mana ${skill.manaCost} Skill : ${skill.name}")
            true
        } else {
            println("Not enough mana for ${skill.name}!")
            false
        }
    }
}