package org.example.com.player

data class SkillData(
    val name: String,
    val manaCost: Int,
    val cooldown: Long,
    val range: Double,
    var lastUsedTime: Long = 0
)