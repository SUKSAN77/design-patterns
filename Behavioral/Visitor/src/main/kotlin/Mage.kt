package org.example

class Mage(private var name: String, private val baseDamage: Double, private val magicDamage: Double) : RolePlayer {

    private var mana: Int = 100

    override fun accept(visitor: CharacterVisitor) {
        visitor.visitMage(this)
    }

    fun getBaseDamage(): Double {
        return this.baseDamage
    }

    fun getMagicDamage(): Double {
        return this.magicDamage
    }

    fun getName(): String {
        return this.name
    }

    fun setMana(mana: Int) {
        this.mana = mana
    }

    fun getMana(): Int {
        return this.mana
    }
}