package org.example.com.player

import org.example.com.handler.SkillHandler

class SkillSystem(private val firstHandler : SkillHandler) {
    fun useSkill(player: Player, skillData: SkillData){
        if (firstHandler.handle(player,skillData)){
            println("${player.name} use Skill : ${skillData.name}")
            player.mana -= skillData.manaCost
            skillData.lastUsedTime = System.currentTimeMillis()
        } else {
            println("Skill ${skillData.name} failed!")
        }
    }
}