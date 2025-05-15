package org.example.com.weapon

import org.example.com.effect.*

class Axe(id: Int, damage: Double, effect: Effect = NormalEffect()) : Weapon(effect, id, damage) {

    init {
        when (effect) {
            is FireEffect -> this.damage += 5
            is FrostEffect -> this.damage += 4
            is ThunderEffect -> this.damage += 3
        }
    }

    override fun enchanted(effect: Effect) {

        if (this.effect::class == effect::class) {
            println("This weapon is already enchanted with the same effect.")
            return
        }

        when (effect) {
            is FireEffect -> {
                this.effect = FireEffect()
                this.damage += 5
            }

            is FrostEffect -> {
                this.effect = FrostEffect()
                this.damage += 4
            }

            is ThunderEffect -> {
                this.effect = ThunderEffect()
                this.damage += 3
            }
        }
    }

    override fun attack(target: String) {
        println("Axe Attack!! $damage damage -> $target")
        effect.applyEffect(target)
    }
}