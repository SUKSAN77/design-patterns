package org.example

class DamageCalculator : CharacterVisitor {
    override fun visitWarrior(warrior: Warrior) {
        val totalDamage = warrior.getBaseDamage() * warrior.getCritical()
        println("🛡️ Player: ${warrior.getName()}")
        println("⚔️ 𝗪𝗮𝗿𝗿𝗶𝗼𝗿 𝗔𝘁𝘁𝗮𝗰𝗸: ${"%.2f".format(totalDamage)} 𝗗𝗮𝗺𝗮𝗴𝗲 💥🔥")
    }

    override fun visitMage(mage: Mage) {
        val totalDamage = mage.getMagicDamage() + mage.getBaseDamage()
        println("🔮 Player: ${mage.getName()}")
        println("✨ 𝗠𝗮𝗴𝗲 𝗔𝘁𝘁𝗮𝗰𝗸: ${"%.2f".format(totalDamage)} 𝗗𝗮𝗺𝗮𝗴𝗲 🔥 (𝑀𝑎𝑔𝑖𝑐) ✨")
    }

    override fun visitArcher(archer: Archer) {
        var arrowBonusDamage = 0.0
        var arrowType = "🪵 Wood"

        when (archer.getArrow()) {
            "iron" -> {
                arrowBonusDamage = 5.0
                arrowType = "🔩 Iron"
            }

            "titanium" -> {
                arrowBonusDamage = 10.0
                arrowType = "⚙️ Titanium"
            }

            "diamond" -> {
                arrowBonusDamage = 15.0
                arrowType = "💎 Diamond"
            }
        }

        val totalDamage = archer.getBaseDamage() + arrowBonusDamage

        println("🏹 Player: ${archer.getName()}")
        println("🎯 𝗔𝗿𝗰𝗵𝗲𝗿 𝗔𝘁𝘁𝗮𝗰𝗸 : ${"%.2f".format(totalDamage)} 𝗗𝗮𝗺𝗮𝗴𝗲 (${arrowType} Arrow) 🏹")
    }

}
