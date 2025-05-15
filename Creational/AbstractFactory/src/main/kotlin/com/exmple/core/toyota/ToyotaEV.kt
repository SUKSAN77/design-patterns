package com.exmple.core.toyota

class ToyotaEV : Toyota {

    override fun createCar() {
        println("Create Toyota EV success!!")
    }
    override fun installEngine() {
        println("install EV Engine")
    }
}