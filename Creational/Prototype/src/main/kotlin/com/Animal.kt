package org.example.com

class Animal(
    id: Number,
    healthPoint: Number,
    private var typeAnimal: String,
    private var canRide: Boolean,
) : Entity(id, healthPoint) {

    private constructor(animal: Animal) : this(
        typeAnimal = animal.typeAnimal,
        canRide = animal.canRide,
        healthPoint = animal.healthPoint,
        id = animal.id,
    )

    override fun show() {
        super.show()
        println("Animal Type : $typeAnimal")
        println("Animal Ride : $canRide")
    }

    override fun clone(): Entity {
        return Animal(this)
    }
}