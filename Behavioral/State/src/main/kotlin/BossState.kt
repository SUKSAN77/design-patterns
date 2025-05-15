package org.example

abstract class BossState {
    open lateinit var name: String
    private lateinit var boss: Boss
    abstract fun isPlayerNearby(distance: Int)
    abstract fun takeDamage(dmg: Int)

    fun setBoss(boss: Boss) {
        this.boss = boss
    }

    fun getBoss(): Boss {
        return this.boss
    }
}
