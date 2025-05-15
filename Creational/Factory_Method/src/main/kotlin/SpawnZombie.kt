package org.example

import java.util.UUID

class SpawnZombie(
    identityKey: String = UUID.randomUUID().toString(),
    damage: Double = 2.5,
    healthPoint: Double = 20.0,
) : Monster(identityKey, damage, healthPoint) {

    override fun spawnMonster(): BaseMonster {
        val mon = Zombie()
        return mon
    }
}