package com.exmple.core.honda

class HondaDiesel : Honda {
    override fun installEngine() {
        println("install Diesel Engine")
    }

    override fun createCar() {
        println("create HondaHybrid success!!")
    }
}