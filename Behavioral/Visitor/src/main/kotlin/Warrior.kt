package org.example

class Warrior(private var name: String, private var baseDamage: Double, private val critical: Double) : RolePlayer {

    private var stamina: Int = 100

    override fun accept(visitor: CharacterVisitor) {
        visitor.visitWarrior(this)
    }

    fun getBaseDamage(): Double {
        return this.baseDamage
    }

    fun setBaseDamage(damage: Double) {
        this.baseDamage = damage
    }

    fun getCritical(): Double {
        return this.critical
    }

    fun getName(): String {
        return this.name
    }

    fun setStamina(stamina: Int) {
        this.stamina = stamina
    }

    fun getStamina(): Int {
        return this.stamina
    }
}