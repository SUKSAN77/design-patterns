package org.example

import java.util.UUID

class SpawnEnderDragon(
    identityKey: String = UUID.randomUUID().toString(),
    damage: Double = 5.5,
    healthPoint: Double = 100.0,
) : Monster(identityKey, damage, healthPoint) {

    override fun spawnMonster(): BaseMonster {
        val mon = EnderDragon()
        return mon
    }
}