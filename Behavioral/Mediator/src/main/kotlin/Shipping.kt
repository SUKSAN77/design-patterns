class Shipping : Restaurant() {

    private lateinit var address: String
    private var isShipping: Boolean = false

    fun getIsShipping(): Boolean {
        return this.isShipping
    }

    fun setIsShipping(shipping: Boolean) {
        this.isShipping = shipping
    }

    fun setAddress(address: String) {
        this.address = address
    }

    fun getAddress(): String {
        return this.address
    }

    fun requestShipping() {
        if (!this.getIsShipping()) {
            println("Processing shipping address ${this.getAddress()}")
            this.setIsShipping(true)
            println("✅ Shipping successful!")

        } else {
            println("Shipping already completed.")
        }
        getMediator().notify(this, "process_shipping")
    }
}