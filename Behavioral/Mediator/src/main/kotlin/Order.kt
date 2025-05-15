class Order(
    private val foodList: MutableList<String>,
    private var orderNumber: String,
    private var isOrder: Boolean = false
) :
    Restaurant() {
    fun getFood(): MutableList<String> {
        return this.foodList
    }

    fun getOrderNumber(): String {
        return this.orderNumber
    }

    fun setIsOrder(order: Boolean) {
        this.isOrder = order
    }

    fun getIsOrder(): Boolean {
        return this.isOrder
    }

    fun deleteFood() {
        this.foodList.clear()
    }

    fun newOrder() {
        this.setIsOrder(true)
        getMediator().notify(this, "order_created")
    }

}
