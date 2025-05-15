class Payment : Restaurant() {
    private lateinit var paymentMethods: String
    private var isPayment: Boolean = false

    fun getIsPayment(): Boolean {
        return this.isPayment
    }

    fun setIsPayment(payment: Boolean) {
        this.isPayment = payment
    }

    fun setPaymentMethods(method: String) {
        this.paymentMethods = method
    }

    fun getPaymentMethods(): String {
        return this.paymentMethods
    }

    fun pay() {
        if (!this.getIsPayment()) {
            println("Processing payment with ${this.getPaymentMethods()}...")
            this.setIsPayment(true)
            println("✅ Payment successful!")

        } else {
            println("Payment already completed.")
        }
        getMediator().notify(this, "process_pay")
    }
}