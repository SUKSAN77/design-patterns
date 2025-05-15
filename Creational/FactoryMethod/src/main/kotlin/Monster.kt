package org.example


abstract class Monster(
    private val identityKey: String,
    private var damage: Double,
    private var healthPoint: Double,
) {
    abstract fun spawnMonster(): BaseMonster

    fun attackPlayer() {
        val mon = spawnMonster()
        mon.move()
        mon.attack()
        mon.spacialAttack()
        when (mon) {
            is Zombie -> println("Zombie Data")
            is Piglin -> println("Piglin Data")
            is EnderDragon -> println("EnderDragon Data")
        }
        println("ID : $identityKey")
        println("Damage : $damage")
        println("HP : $healthPoint")
    }

    fun set(damage: Double, healthPoint: Double) {
        this.damage = damage
        this.healthPoint = healthPoint
    }

    fun setDamage(damage: Double) {
        this.damage = damage
    }

    fun setHealthPoint(healthPoint: Double) {
        this.healthPoint = healthPoint
    }

    fun getUUID(): String {
        return this.identityKey
    }

    fun getDamage(): Double {
        return this.damage
    }

    fun getHealthPoint(): Double{
        return this.healthPoint
    }


    fun showDataMonster() {
        println("ID : $identityKey")
        println("Damage : $damage")
        println("HP : $healthPoint")
    }
}