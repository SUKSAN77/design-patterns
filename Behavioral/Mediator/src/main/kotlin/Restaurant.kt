import mediator.RestaurantMediator

open class Restaurant(private var isOrder: Boolean = false) {

    private lateinit var mediator: RestaurantMediator

    fun getMediator(): RestaurantMediator {
        return this.mediator
    }

    fun setMediator(m: RestaurantMediator) {
        this.mediator = m
    }

    fun cancel() {
        mediator.notify(this, "cancel")
    }

    fun check() {
        mediator.notify(this, "check")
    }

    fun completeOrder() {
        mediator.notify(this, "complete")
    }
}
