package mediator

import Order
import Payment
import Restaurant
import Shipping

class DeliveryMediator(
    private val order: Order,
    private val payment: Payment,
    private val shipping: Shipping
) :
    RestaurantMediator {

    init {
        this.order.setMediator(this)
        this.payment.setMediator(this)
        this.shipping.setMediator(this)
    }

    override fun notify(sender: Restaurant, msg: String) {

        when {
            sender is Order && msg == "order_created" -> {
                payment.setPaymentMethods("Credit Card, Cash")
                shipping.setAddress("Pick-up-at-restaurant")
                println("🆔 Order Number: ${order.getOrderNumber()}")
                println("✅ Order Created")
            }
        }

        if (!order.getIsOrder()) {
            println("⚠️ No orders placed.")
            return
        }

        when {
            sender is Payment && msg == "process_pay" -> {
                println("🆔 Order Number: ${order.getOrderNumber()}")
                val isShipping = if (shipping.getIsShipping()) "✅ Shipped successfully" else "⚠️ Not yet shipped"
                println("🚚 Shipping Address: ${shipping.getAddress()} $isShipping")
            }

            sender is Shipping && msg == "process_shipping" -> {
                println("🆔 Order Number: ${order.getOrderNumber()}")
                val isPayment = if (payment.getIsPayment()) "✅ Payment completed" else "⚠️ No payment made."
                println("💳 Payment: ${payment.getPaymentMethods()} $isPayment")
            }
        }

        when (msg) {
            "complete" -> {
                if (!payment.getIsPayment()) {
                    println("⚠️ No payment made.")
                    return
                }

                if (!shipping.getIsShipping()) {
                    println("⚠️ Not yet shipped")
                    return
                }

                println("✅ Order Complete")
            }

            "cancel" -> {
                println("🛑 Order Canceled: ${order.getOrderNumber()}")
                order.deleteFood()
                payment.setIsPayment(false)
                shipping.setIsShipping(false)
                payment.setPaymentMethods("---Cancel---")
                shipping.setAddress("---Cancel---")
            }

            "check" -> {
                println("📦 Order Summary")
                println("🆔 Order Number: ${order.getOrderNumber()}")
                val foodList = order.getFood().joinToString(", ").ifEmpty { "⚠️ No food items." }
                println("🍽 Food List: $foodList")
                val isPayment = if (payment.getIsPayment()) "✅ Payment completed" else "⚠️ No payment made."
                println("💳 Payment: ${payment.getPaymentMethods()} $isPayment")
                val isShipping = if (shipping.getIsShipping()) "✅ Shipped successfully" else "⚠️ Not yet shipped"
                println("🚚 Shipping Address: ${shipping.getAddress()} $isShipping")
            }
        }
    }
}
