package org.example.com.product

class PC(
    private var series: String = "New",
    private var cpu: String = "New",
    private var gpu: String = "New",
    private var ram: String = "New",
    private var ssd: Int = 0,
    private var hdd: Int = 0,
    private var bluetooth: Boolean = false,
    private var wifi: Boolean = false,
    private var touchpad: Boolean = false,
) {
    private fun calculateTB(gb: Int): Int {
        if (gb >= 1024) {
            val result = gb / 1024
            return result
        }
        return gb
    }

    fun setSeries(series: String) {
        this.series = series
        println("PC Series Name ${this.series}")
    }

    fun setMainborad() {
        println("Install motherboard into PC...")
    }

    fun setCPU(cpu: String) {
        this.cpu = cpu
        println("Install CPU : ${this.cpu} into PC...")
    }

    fun setGPU(gpu: String) {
        this.gpu = gpu
        println("Install GPU : ${this.gpu} into PC...")
    }

    fun setRAM(ram: String) {
        this.ram = ram
        println("Install RAM : ${this.ram} into PC...")
    }

    fun setStorageSSD(ssd: Int) {
        this.ssd = calculateTB(ssd)
        println("Install Solid State Drive : ${if (calculateTB(ssd) > 256) "${getSSD()} GB" else "${getSSD()} TB"}")
    }

    fun setStorageHDD(hdd: Int) {
        this.hdd = calculateTB(hdd)
        println("Install Hard Disk Drive : ${if (calculateTB(hdd) > 256) "${getHDD()} GB" else "${getHDD()} TB"}")
    }

    fun setBluetooth(bluetooth: Boolean) {
        this.bluetooth = bluetooth
        println("Install Bluetooth into PC...")
    }

    fun setTouchpad(touchpad: Boolean) {
        this.touchpad = touchpad
        println("Install Touchpad into PC...")
    }

    fun setWifi(wifi: Boolean) {
        this.wifi = wifi
        println("Install Wifi into PC...")
    }

    fun getCPU(): String {
        return cpu
    }

    fun getGPU(): String {
        return gpu
    }

    fun getRAM(): String {
        return ram
    }

    fun getSSD(): Int {
        return ssd
    }

    fun getHDD(): Int {
        return hdd
    }

    fun show() {
        println("$series PC Spec ")
        println("CPU : ${getCPU()}")
        println("GPU : ${getGPU()}")
        println("RAM : ${getRAM()}")
        if (getSSD() != 0) {
            println("SSD Storage : ${if (calculateTB(ssd) > 256) "${getSSD()} GB" else "${getSSD()} TB"}")
        }
        if (getHDD() != 0) {
            println("HDD Storage : ${if (calculateTB(hdd) > 256) "${getHDD()} GB" else "${getHDD()} TB"}")
        }
    }
}