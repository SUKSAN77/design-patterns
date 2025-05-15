package publisher

import concrete.Observer

interface Publisher {
    fun subscribe(observer: Observer)
    fun unsubscribe(observer: Observer)
    fun notifyObservers()
}