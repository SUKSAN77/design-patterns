package org.example

fun callMonster(mon : Monster){
    mon.attackPlayer()
}

fun main() {

    println("--------Zombie--------")
    var mon : Monster = SpawnZombie()
    callMonster(mon)
    println("--------Piglin--------")
    mon = SpawnPiglin()
    callMonster(mon)
    println("--------EnderDragon--------")
    mon =  SpawnEnderDragon()
    callMonster(mon)


    println("--------Getter&Setter--------")
    mon.set(30.00,120.00)
    println(mon.getUUID())
    println(mon.getDamage())
    println(mon.getHealthPoint())
    println("--------Getter&Setter2--------")
    mon.setDamage(50.00)
    mon.setHealthPoint(300.00)
    mon.showDataMonster()
}