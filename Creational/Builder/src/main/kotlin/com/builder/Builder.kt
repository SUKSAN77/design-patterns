package org.example.com.builder

interface Builder {
    fun setSeries(series: String)
    fun installMainboard()
    fun installCPU(cpu: String)
    fun installRAM(ram: String)
    fun installGPU(gpu: String)
    fun installSSD(ssd: Int)
    fun installHDD(hdd: Int)
    fun installWifi(wifi: Boolean)
    fun installBluetooth(bt: Boolean)
    fun installTouchpad(tp: Boolean)
}