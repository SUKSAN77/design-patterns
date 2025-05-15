package org.example.area

import area.GameArea

class AncientRuins : GameArea() {

    override fun createArea() {
        super.createArea()
        createCastle()
    }

    override fun createMap() {
        println("🏛️ Generating an ancient ruins map with crumbling structures and hidden chambers...")
    }

    override fun createTerrain() {
        println("🌿 Overgrown vines cover the cracked stone pathways and ancient pillars...")
    }

    private fun createCastle() {
        println("🏰 A grand but decaying castle stands in the heart of the ruins, its towers reaching for the sky.")
    }

    override fun spawnBoss() {
        println("👹 The Cursed Pharaoh awakens from his eternal slumber! ⚰️🔥")
    }

    override fun spawnMiniBoss() {
        println("🗿 Stone Guardians come to life, protecting the sacred relics...")
    }

    override fun spawnMonster() {
        println("🦴 Skeleton warriors and shadow wraiths roam the ruins, attacking intruders...")
    }

    override fun reward() {
        println("💎 A legendary artifact and ancient gold coins are uncovered! 🏆")
    }

}
