package org.example

class CombatState : BossState() {

    override var name = "combat"

    override fun isPlayerNearby(distance: Int) {
        val boss = getBoss()
        when {
            (boss.getHp() < 30) -> boss.changeState(RageState())
            (distance >= 50) -> boss.changeState(SleepingState())
            else -> boss.changeState(CombatState())
        }

    }

    override fun takeDamage(dmg: Int) {
        val boss = getBoss()
        boss.setHp((boss.getHp() - dmg).coerceAtLeast(0)) // ป้องกัน HP ติดลบ
        println("⚔️ Boss took $dmg damage! HP: ${boss.getHp()}")
        when {
            (boss.getHp() < 30) -> boss.changeState(RageState())
            (boss.getHp() == 0) -> boss.changeState(SleepingState())
            else -> boss.changeState(CombatState())
        }
    }
}
