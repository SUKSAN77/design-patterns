package org.example.area

import area.GameArea

class MagicForest : GameArea() {

    override fun createMap() {
        println("🌲 Creating an enchanted forest map with glowing trees and hidden paths...")
    }

    override fun createTerrain() {
        println("🏞️ Adding dense mystical trees, rivers, and floating islands...")
    }

    override fun spawnBoss() {
        println("👾 Spawning the Ancient Tree Guardian as the main boss! 🌳⚔️")
    }

    override fun spawnMiniBoss() {
        println("🧝 Placing the Shadow Elf as the mini boss in a hidden cave...")
    }

    override fun spawnMonster() {
        println("🐺 Scattering Forest Spirits and Magical Wolves around the area...")
    }

    override fun reward() {
        println("🎁 Rewarding players with enchanted artifacts and rare potions! ✨")
    }
}
