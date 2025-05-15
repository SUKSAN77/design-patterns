package org.example

class Archer(private var name: String, private val baseDamage: Double, private var arrow: String) : RolePlayer {

    private var arrowAmount: Int = 100

    override fun accept(visitor: CharacterVisitor) {
        visitor.visitArcher(this)
    }

    fun getArrow(): String {
        return this.arrow
    }

    fun getBaseDamage(): Double {
        return this.baseDamage
    }

    fun setArrow(arrow: String) {
        this.arrow = arrow
    }

    fun getName(): String {
        return this.name
    }

    fun setArrowAmount(amount: Int) {
        this.arrowAmount = amount
    }

    fun getArrowAmount(): Int {
        return this.arrowAmount
    }
}