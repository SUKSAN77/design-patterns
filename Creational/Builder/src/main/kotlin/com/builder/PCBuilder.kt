package org.example.com.builder

import org.example.com.product.PC

class PCBuilder(private var pc: PC = PC()) : Builder {

    private fun reset() {
        pc = PC()
    }

    fun getProduct(): PC {
        val product: PC = this.pc
        this.reset()
        return product
    }

    override fun setSeries(series: String) {
        this.pc.setSeries(series)
    }

    override fun installMainboard() {
        this.pc.setMainborad()
    }

    override fun installCPU(cpu: String) {
        this.pc.setCPU(cpu)
    }

    override fun installGPU(gpu: String) {
        this.pc.setGPU(gpu)
    }

    override fun installRAM(ram: String) {
        this.pc.setRAM(ram)
    }

    override fun installSSD(ssd: Int) {
        this.pc.setStorageSSD(ssd)
    }

    override fun installHDD(hdd: Int) {
        this.pc.setStorageHDD(hdd)
    }

    override fun installBluetooth(bt: Boolean) {
        this.pc.setBluetooth(bt)
    }

    override fun installTouchpad(tp: Boolean) {
        this.pc.setTouchpad(tp)
    }

    override fun installWifi(wifi: Boolean) {
        this.pc.setWifi(wifi)
    }
}