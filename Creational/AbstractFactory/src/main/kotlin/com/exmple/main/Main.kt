package com.exmple.main

import com.exmple.core.honda.Honda
import com.exmple.core.hyundai.Hyundai
import com.exmple.core.toyota.Toyota
import com.exmple.factory.CarFactory
import com.exmple.factory.DieselFactory
import com.exmple.factory.EVFactory
import com.exmple.factory.HybridFactory

fun saleCar(fac: CarFactory) {
    when (fac.getBrand().lowercase()) {
        "honda" -> {
            val car: Honda = fac.createHonda()
            fac.show()
            car.installEngine()
            car.createCar()
        }

        "toyota" -> {
            val car: Toyota = fac.createToyota()
            fac.show()
            car.installEngine()
            car.createCar()
        }

        "hyundai" -> {
            val car: Hyundai = fac.createHyundai()
            fac.show()
            car.installEngine()
            car.createCar()
        }
        else -> {
            println("No preferred brand!")
        }
    }
}


fun main() {
    println("Brand Car : Toyota, Honda, Hyundai")
    println("------Sale Toyota EV------")
    var car: CarFactory = EVFactory("Toyota", "Toyota Cross")
    saleCar(car)
    println("------Sale Honda Hybrid------")
    car = HybridFactory("Honda", "Accord Hybrid")
    saleCar(car)
    println("------Sale Hyundai Diesel------")
    car = DieselFactory("Hyundai","H1")
    saleCar(car)
}