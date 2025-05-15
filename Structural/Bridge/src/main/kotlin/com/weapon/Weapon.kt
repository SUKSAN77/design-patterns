package org.example.com.weapon

import org.example.com.effect.Effect

abstract class Weapon(protected var effect: Effect, private val id: Int, protected var damage: Double) {
    abstract fun enchanted(effect: Effect)
    abstract fun attack(target: String)
    fun getID(): Int {
        return this.id
    }
}