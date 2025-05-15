package com.exmple.core.toyota

class ToyotaHybrid: Toyota {

    override fun installEngine() {
        println("install Hybrid Engine")
    }

    override fun createCar() {
        println("Create Toyota Hybrid success!!")
    }
}