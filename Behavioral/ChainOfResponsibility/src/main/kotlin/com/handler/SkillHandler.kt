package org.example.com.handler

import org.example.com.player.Player
import org.example.com.player.SkillData

interface SkillHandler {
    fun setNext(skill: SkillHandler): SkillHandler
    fun handle(player: Player, skillData: SkillData): Boolean
}