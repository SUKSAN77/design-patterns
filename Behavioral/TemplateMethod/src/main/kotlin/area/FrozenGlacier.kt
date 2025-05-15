package org.example.area

import area.GameArea

class FrozenGlacier : GameArea() {

    override fun createArea() {
        super.createArea()
        createColdWeather()
    }

    override fun createTerrain() {
        println("❄️ Creating a vast icy terrain with frozen lakes and towering glaciers...")
    }

    private fun createColdWeather() {
        println("🌨️ A blizzard is sweeping through the glacier, reducing visibility and freezing everything.")
    }

    override fun spawnBoss() {
        println("🐉 Summoning the Frost Dragon, ruler of the icy wastelands! ❄️🔥")
    }

    override fun spawnMonster() {
        println("🐺 Ice Wolves and Frost Spirits roam the land, hunting intruders...")
    }

    override fun reward() {
        println("💎 Players receive a Legendary Ice Crystal and enchanted frost gear! 🏆")
    }
}
