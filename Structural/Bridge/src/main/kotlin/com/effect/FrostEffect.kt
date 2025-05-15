package org.example.com.effect

class FrostEffect : Effect {
    override fun applyEffect(target: String) {
        println("The $target is frozen")
    }
}