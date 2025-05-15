package org.example

import java.util.UUID

class SpawnPiglin(
    identityKey: String = UUID.randomUUID().toString(),
    damage: Double = 3.5,
    healthPoint: Double = 35.0,
) : Monster(identityKey, damage, healthPoint) {

    override fun spawnMonster(): BaseMonster {
        val mon = Piglin()
        return mon
    }
}