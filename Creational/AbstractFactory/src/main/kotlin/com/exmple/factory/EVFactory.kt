package com.exmple.factory

import com.exmple.core.honda.Honda
import com.exmple.core.honda.HondaEV
import com.exmple.core.hyundai.Hyundai
import com.exmple.core.hyundai.HyundaiEV
import com.exmple.core.toyota.Toyota
import com.exmple.core.toyota.ToyotaEV

class EVFactory(private val brand: String, private val name: String) : CarFactory(brand, name) {

    override fun createHonda(): Honda {
        return HondaEV()
    }

    override fun createHyundai(): Hyundai {
        return HyundaiEV()
    }

    override fun createToyota(): Toyota {
        return ToyotaEV()
    }
}