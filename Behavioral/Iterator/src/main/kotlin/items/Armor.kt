package items

import java.util.UUID

class Armor (
    private val type: String,
    private val name: String,
    private val rarity: Rarity,
    private val defend: Double,
    private val evade: Double
) : Item {
    private val uuid: UUID = UUID.randomUUID()

    override fun getRarity(): Rarity {
        return this.rarity
    }

    fun getType(): String {
        return this.type
    }

    fun getUUID(): UUID {
        return this.uuid
    }

    override fun showItemDetail() {
        println("🛡️✨ Armor Details ✨🛡️")
        println("🔑 UUID         : $uuid")
        println("🏷️ Name         : $name")
        println("⚔️ Type         : $type")
        println("🌟 Rarity       : $rarity")
        println("💨 Evade        : $evade%")
        println("🛡️ Defend       : $defend%")
        println("───────────────────────")
    }
}