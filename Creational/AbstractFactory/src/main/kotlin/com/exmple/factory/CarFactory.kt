package com.exmple.factory

import com.exmple.core.honda.Honda
import com.exmple.core.hyundai.Hyundai
import com.exmple.core.toyota.Toyota

abstract class CarFactory(private var brand: String, private var name: String) {
    abstract fun createHonda(): Honda
    abstract fun createToyota(): Toyota
    abstract fun createHyundai(): Hyundai

    fun show() {
        println("Brand : $brand")
        println("Name : $name")
    }

    fun setName(name: String) {
        this.name = name
    }

    fun setBrand(brand: String) {
        this.brand = brand
    }

    fun getName(): String {
        return name
    }

    fun getBrand(): String {
        return brand
    }
}