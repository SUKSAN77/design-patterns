package com.exmple.core.toyota

class ToyotaDiesel : Toyota {

    override fun createCar() {
        println("install Diesel Engine")
    }

    override fun installEngine() {
        println("Create Toyota Diesel success!!")
    }
}