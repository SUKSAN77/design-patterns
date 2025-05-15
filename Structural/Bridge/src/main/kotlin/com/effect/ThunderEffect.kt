package org.example.com.effect

class ThunderEffect : Effect {
    override fun applyEffect(target: String) {
        println("The $target is paralyzed")
    }
}