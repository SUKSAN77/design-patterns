package player

class Player(
    private var name: String,
    private var role: RolePlayer,
    private var level: Int = 0
) {

    fun getName(): String {
        return this.name
    }

    fun getRole(): RolePlayer {
        return this.role
    }

    fun getLevel(): Int {
        return this.level
    }

    private fun getRoleIcon(): String {
        return when (role.name) {
            "warrior" -> "🛡️"
            "archer" -> "🏹"
            "mage" -> "🔥"
            "support" -> "🍀"
            else -> ""
        }
    }

    fun showDetailPlayer() {
        println("\n🎮 Player Profile")
        println("------------------------")
        println("🆔 Name: $name")
        println("🎭 Role: ${getRoleIcon()} $role")
        println("⭐ Level: $level")
        println("------------------------")
    }
}
