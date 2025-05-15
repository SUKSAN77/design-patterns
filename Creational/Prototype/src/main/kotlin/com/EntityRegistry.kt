package org.example.com

class EntityRegistry {
    private val entityItems: MutableList<Entity> = mutableListOf(
        Character(1, "Player", 20, "Axe", 1, "Warrior"),
        Monster(2, "Zombie", 30, 2.5),
        Animal(3, 20, "Pig", true)
    )

    fun addItems(entity: Entity) {
        entityItems.add(entity)
    }

    fun sizeOfRegistry(): Int {
        return entityItems.size
    }

    fun getByID(id: Number): Entity {
        for (entity in entityItems) {
            if (entity.getID() == id) {
                return entity.clone()
            }
        }
        println("Entity with ID $id not found. Returning default Entity.")
        return entityItems[0].clone()
    }
}
