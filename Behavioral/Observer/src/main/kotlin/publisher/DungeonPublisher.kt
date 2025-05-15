package publisher

import concrete.Observer

class DungeonPublisher : Publisher {

    private val observers: MutableList<Observer> = mutableListOf()
    private lateinit var message: String
    private lateinit var boss: String

    override fun subscribe(observer: Observer) {
        this.observers.add(observer)
    }

    override fun unsubscribe(observer: Observer) {
        this.observers.remove(observer)
    }

    override fun notifyObservers() {
        this.observers.forEach { it.update(message) }
    }

    fun setMessage(message: String) {
        this.message = message
    }

    fun setBoss(name: String) {
        this.boss = name
    }

    fun bossDefeated() {
        println("🔥 ${this.boss} has been defeated! 🔥")
        this.setMessage("Boss ${this.boss} has been defeated! 🎉")
        notifyObservers()
    }

}