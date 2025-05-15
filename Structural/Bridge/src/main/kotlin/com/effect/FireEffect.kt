package org.example.com.effect

class FireEffect : Effect {
    override fun applyEffect(target: String) {
        println("The $target is Burning")
    }
}