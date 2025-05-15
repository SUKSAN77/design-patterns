package org.example

class SleepingState : BossState() {

    override var name = "sleeping"

    override fun isPlayerNearby(distance: Int) {
        val boss = getBoss()
        when {
            (boss.getHp() < 30) -> boss.changeState(RageState())
            (distance < 50) -> boss.changeState(CombatState())
            else -> boss.changeState(SleepingState())
        }
    }

    override fun takeDamage(dmg: Int) {
        val boss = getBoss()

        if (boss.getHp() <= 0) {
            println("⚠️ Player tries to attack, but the boss is already dead!")
            return
        }

        boss.setHp((boss.getHp() - dmg).coerceAtLeast(0)) // ป้องกัน HP ติดลบ
        println("💤 Boss is sleeping but took $dmg damage! HP: ${boss.getHp()}")

        if (boss.getHp() <= 0) {
            println("💀 Boss has been defeated!")
            boss.changeState(SleepingState())
        }

        if (boss.getHp() < 30) {
            println("🔥 Boss enters Rage Mode!")
            boss.changeState(RageState())
        } else {
            println("😠 Boss wakes up and enters Combat Mode!")
            boss.changeState(CombatState())
        }
    }

}