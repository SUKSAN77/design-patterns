package com.exmple.factory

import com.exmple.core.honda.Honda
import com.exmple.core.honda.HondaDiesel
import com.exmple.core.hyundai.Hyundai
import com.exmple.core.hyundai.HyundaiDiesel
import com.exmple.core.toyota.Toyota
import com.exmple.core.toyota.ToyotaDiesel

class DieselFactory(private var brand: String, private var name: String) : CarFactory(brand, name) {

    override fun createHonda(): Honda {
        return HondaDiesel()
    }

    override fun createHyundai(): Hyundai {
        return HyundaiDiesel()
    }

    override fun createToyota(): Toyota {
        return ToyotaDiesel()
    }
}