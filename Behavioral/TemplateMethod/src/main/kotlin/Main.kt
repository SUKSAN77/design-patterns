package org.example

import area.GameArea
import org.example.area.AncientRuins
import org.example.area.FrozenGlacier
import org.example.area.MagicForest

fun main() {
    println("🌍 Game World Initialized! Let's explore the areas...")


    fun client(area: GameArea){
        area.createArea()
    }

    // MagicForest
    println("\n🌲---- Exploring the Magic Forest ----🌲")
    val areaForest = MagicForest()
    areaForest.createArea() // Creating the area for Magic Forest

    // FrozenGlacier
    println("\n❄️---- Exploring the Frozen Glacier ----❄️")
    val areaFrozen = FrozenGlacier()
    areaFrozen.createArea() // Creating the area for Frozen Glacier

    // AncientRuins
    println("\n🏛️---- Exploring the Ancient Ruins ----🏛️")
    val areaAncient = AncientRuins()
    areaAncient.createArea() // Creating the area for Ancient Ruins

    println("\n---- Test dynamic ----️")

    client(areaForest)
}
