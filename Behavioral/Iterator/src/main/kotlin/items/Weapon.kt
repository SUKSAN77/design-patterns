package items

import java.util.UUID

class Weapon(
    private val type: String,
    private val name: String,
    private val rarity: Rarity,
    private val critical: Double,
    private val damage: Double
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
        println("🛡️✨ Weapon Details ✨🛡️")
        println("🆔 UUID       : $uuid")
        println("🏷️ Name       : $name")
        println("⚔️ Type       : $type")
        println("🟣 Rarity     : $rarity")
        println("💥 Critical   : $critical%")
        println("🔥 Damage     : $damage")
        println("───────────────────────")
    }
}
