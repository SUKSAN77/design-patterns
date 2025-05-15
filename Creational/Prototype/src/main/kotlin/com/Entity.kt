package org.example.com

abstract class Entity(protected var id: Number, protected var healthPoint: Number) {

    fun getID(): Number {
        return id
    }

    open fun show() {
        println("Entity ID : $id")
        println("Entity HealthPoint : $healthPoint")
    }

    abstract fun clone(): Entity
}