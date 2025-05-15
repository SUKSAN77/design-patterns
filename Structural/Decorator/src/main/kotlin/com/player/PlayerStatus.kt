package org.example.com.player

interface PlayerStatus {
    val name : String
    val attackPower: Double
    val maxHp: Double
    fun descriptionBuff(): String
    fun showStatus()
}