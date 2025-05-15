package org.example

class Boss(
    private var name: String,
    private var hp: Int,
    private var dmg: Int,
    private var state: BossState
) {

    private var playerDistance: Int = 200

    init {
        state.setBoss(this)
    }

    fun changeState(newState: BossState) {
        println("🌀 Changing state from ${state.name} to ${newState.name}")
        println("💀 Boss Hp : ${this.hp}")
        state = newState
        state.setBoss(this)
    }

    fun isPlayerNearby(distance: Int) {
        state.isPlayerNearby(distance)
    }

    fun takeDamage(dmg: Int) {
        state.takeDamage(dmg)
    }

    fun getHp(): Int {
        return this.hp
    }

    fun setHp(hp: Int) {
        this.hp = hp
    }
}
