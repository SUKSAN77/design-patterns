package org.example.com

class Monster(
    id: Number,
    private var type: String,
    healthPoint : Number,
    private var damage: Number,
) : Entity(id, healthPoint) {

    private constructor(monster: Monster) : this(  //ไม่จำเป็นต้องprivete
        type = monster.type,
        damage = monster.damage,
        healthPoint = monster.healthPoint,
        id = monster.id,
    )

    override fun show() {
        super.show()
        println("Monster Type : $type")
        println("Monster damage : $damage")
    }

    override fun clone(): Entity {
        return Monster(this)
    }
}