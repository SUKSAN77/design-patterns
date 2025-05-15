package org.example.com

class Character(
    id: Number,
    private var name: String,
    healthPoint: Number,
    private var weapon: String,
    private var level: Number,
    private var classJob: String,
) : Entity(id, healthPoint) {

    private constructor(character: Character) : this(
        name = character.name,
        weapon = character.weapon,
        level = character.level,
        classJob = character.classJob,
        id = character.id,
        healthPoint = character.healthPoint
    )

    override fun show() {
        super.show()
        println("Character Name : $name")
        println("Character Weapon : $weapon")
        println("Character Level : $level")
        println("Character ClassJob : $classJob")
    }

    override fun clone(): Entity {
        return Character(this)
    }
}