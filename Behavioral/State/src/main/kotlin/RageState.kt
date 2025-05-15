package org.example

class RageState : BossState() {

    override var name = "rage"
    override fun isPlayerNearby(distance: Int) {
        val boss = getBoss()
        when {
            boss.getHp() >= 30 -> boss.changeState(CombatState())
            distance >= 50 && boss.getHp() > 0 -> boss.changeState(SleepingState())
            else -> boss.changeState(RageState())
        }

    }

    override fun takeDamage(dmg: Int) {
        val boss = getBoss()
        boss.setHp((boss.getHp() - dmg).coerceAtLeast(0)) // ป้องกัน HP ติดลบ
        println("🔥 Boss took $dmg damage! Remaining HP: ${boss.getHp()}")
        if (boss.getHp() <= 0) {
            println("💀 Boss Defeated!")
            boss.changeState(SleepingState())
        } else {
            boss.changeState(RageState())
        }
    }
}