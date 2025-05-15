package org.example.com.player

data class Player(
    var name: String,
    var mana: Int,
    var distanceToEnemy: Double,
    var hasBuff: Boolean,
    var isStunned: Boolean
)

