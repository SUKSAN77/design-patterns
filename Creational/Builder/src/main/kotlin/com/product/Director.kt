package org.example.com.product

import org.example.com.builder.Builder
import org.example.com.builder.NoteBookBuilder

class Director {
    fun makeComputerGaming(builder: Builder, series: String) {
        builder.setSeries(series)
        builder.installMainboard()
        builder.installCPU("Intel Core i7 13420H")
        builder.installGPU("RTX4060Ti")
        builder.installRAM("64GB DD5")
        builder.installSSD(1024)
        builder.installHDD(2048)
        builder.installWifi(true)
        builder.installBluetooth(true)
        builder.installTouchpad(true)
    }

    fun makeComputerWithOutTouchpad(builder: Builder, series: String) {
        builder.setSeries(series)
        builder.installMainboard()
        builder.installCPU("Intel Core i3 13420H")
        builder.installGPU("ONBoard")
        builder.installRAM("16GB DD5")
        builder.installSSD(1024)
        builder.installWifi(true)
        builder.installBluetooth(true)
    }
}