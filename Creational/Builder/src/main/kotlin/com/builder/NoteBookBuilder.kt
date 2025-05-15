package org.example.com.builder

import org.example.com.product.NoteBook

class NoteBookBuilder(private var notebook: NoteBook = NoteBook()) : Builder {

    private fun reset() {
        notebook = NoteBook()
    }

    fun getProduct(): NoteBook {
        val product: NoteBook = this.notebook
        this.reset()
        return product
    }

    override fun setSeries(series: String) {
        this.notebook.setSeries(series)
    }

    override fun installMainboard() {
        this.notebook.setMainborad()
    }

    override fun installCPU(cpu: String) {
        this.notebook.setCPU(cpu)
    }

    override fun installGPU(gpu: String) {
        this.notebook.setGPU(gpu)
    }

    override fun installRAM(ram: String) {
        this.notebook.setRAM(ram)
    }

    override fun installSSD(ssd: Int) {
        this.notebook.setStorageSSD(ssd)
    }

    override fun installHDD(hdd: Int) {
        this.notebook.setStorageHDD(hdd)
    }

    override fun installBluetooth(bt: Boolean) {
        this.notebook.setBluetooth(bt)
    }

    override fun installTouchpad(tp:Boolean) {
        this.notebook.setTouchpad(tp)
    }

    override fun installWifi(wifi:Boolean) {
        this.notebook.setWifi(wifi)
    }
}