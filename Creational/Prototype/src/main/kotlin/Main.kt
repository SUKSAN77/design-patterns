package org.example

import org.example.com.Animal
import org.example.com.EntityRegistry

fun client(entityRegistry: EntityRegistry) {
    for (i in 1..entityRegistry.sizeOfRegistry()) {
        println()
        println("Create Copy")
        val entityCopy = entityRegistry.getByID(i)
        entityCopy.show()
    }
}

fun main() {
    println("Before Add Method")
    val entity = EntityRegistry()
    client(entity)
    println("------------------------------------------")

    println("After Add Method")
    val animal = Animal(4, 20, "Cow", false)
    entity.addItems(animal)
    client(entity)
    println("------------------------------------------")

    println("Copy Entity Byid")
    val copyEntity = entity.getByID(1)
    copyEntity.show()
    println("------------------------------------------")
}