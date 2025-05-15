package org.example

fun client(playerList: MutableList<RolePlayer>, visitor: CharacterVisitor) {
    playerList.forEach { it.accept(visitor) }
}

fun main() {
    println("Hello World!")
    val playerWarrior = Warrior("Knight", 10.0, 5.0)
    val playerMage = Mage("ArcaneMage", 5.0, 20.0)
    val playerArcher = Archer("SilverArcher", 8.0, "diamond")

    val playerList: MutableList<RolePlayer> = mutableListOf(playerWarrior, playerMage, playerArcher)

    val visitor = DamageCalculator()
    val visitorSkill = SkillActive()
    client(playerList, visitor)
    client(playerList,visitorSkill)

    println("Warrior : Stamina ${playerWarrior.getStamina()}")
    println("Mage : Mana ${playerMage.getMana()}")
    println("Archer : Arrow Amount ${playerArcher.getArrowAmount()}")
}