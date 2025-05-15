package org.example

class SkillActive : CharacterVisitor {
    override fun visitWarrior(warrior: Warrior) {
        if (warrior.getStamina() >= 30) {
            println("Warrior ${warrior.getName()} ใช้สกิล 'Rage Mode' เพิ่มพลังโจมตี 15 หน่วย")
            val totalDamage = warrior.getBaseDamage() + 15
            warrior.setBaseDamage(totalDamage)
            val decreaseStamina = warrior.getStamina() - 30
            warrior.setStamina(decreaseStamina)
        } else {
            println("Warrior ${warrior.getName()} ไม่มี Stamina พอสำหรับใช้สกิล")
        }
    }

    override fun visitMage(mage: Mage) {
        if (mage.getMana() >= 30) {
            println("Mage ${mage.getName()} ใช้สกิล 'Fireball' โจมตีศัตรูด้วยเวทย์ไฟ!")
            val decreaseMana = mage.getMana() - 30
            mage.setMana(decreaseMana)
        } else {
            println("Mage ${mage.getName()} ไม่มี Mana พอสำหรับใช้สกิล!")
        }
    }

    override fun visitArcher(archer: Archer) {
        if (archer.getArrowAmount() >= 20) {
            println("Archer ${archer.getName()} ใช้สกิล 'Multi-Shot' ยิงธนูต่อเนื่อง 20 ดอก")
            val decreaseArrow = archer.getArrowAmount() - 20
            archer.setArrowAmount(decreaseArrow)
        } else {
            println("Archer ${archer.getName()} ไม่มี Arrow พอสำหรับใช้สกิล!")
        }
    }
}