package org.example

fun main() {
    val boss = Boss("ToonLnwZa",100,50, SleepingState())

    println("🎮 Player approaches...")
    boss.isPlayerNearby(30)

    println("🎮 Player attacks!")
    boss.takeDamage(80)

    println("🎮 Player comeback!")
    boss.isPlayerNearby(200)

    println("🎮 Player come again!")
    boss.isPlayerNearby(25)

    println("🎮 Player attacks!")
    boss.takeDamage(80)

    println("🎮 Player attacks again!")
    boss.takeDamage(20)


//    println("🎮 Player tries to attack dead boss...")
//    boss.takeDamage(10)
}