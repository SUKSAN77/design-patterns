package com.exmple.factory

import com.exmple.core.honda.Honda
import com.exmple.core.honda.HondaHybrid
import com.exmple.core.hyundai.Hyundai
import com.exmple.core.hyundai.HyundaiHybrid
import com.exmple.core.toyota.Toyota
import com.exmple.core.toyota.ToyotaHybrid

class HybridFactory(private val brand: String, private val name: String) : CarFactory(brand, name) {

    override fun createHonda(): Honda {
        return HondaHybrid()
    }

    override fun createHyundai(): Hyundai {
        return HyundaiHybrid()
    }

    override fun createToyota(): Toyota {
        return ToyotaHybrid()
    }
}