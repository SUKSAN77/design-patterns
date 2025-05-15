package area

abstract class GameArea {
    open fun createArea() {
        println("🌍 Initializing game area...")
        this.createMap()
        this.createTerrain()
        this.spawnBoss()
        this.spawnMiniBoss()
        this.spawnMonster()
        this.reward()
    }

    protected open fun createMap() {
        println("🗺️ Generating base map layout...")
    }

    protected abstract fun createTerrain()

    protected abstract fun spawnBoss()

    protected open fun spawnMiniBoss() {
        println("🛡️ Generating mini-boss in this area.")
    }

    protected abstract fun spawnMonster()

    protected abstract fun reward()
}
