import mediator.DeliveryMediator

fun main() {
    val orderList = mutableListOf("Pizza", "Burger", "Pasta")
    val myOrder = Order(orderList, "0001")
    val shipping = Shipping()
    val payment = Payment()

    DeliveryMediator(myOrder, payment, shipping)

    println("---------------------Make Order---------------------")
    myOrder.newOrder()
    println("---------------------Check Order---------------------")
    myOrder.check()

    println("---------------------Test Complete Order---------------------")
    myOrder.completeOrder()

    println("---------------------Process Payment---------------------")
    payment.setPaymentMethods("Cash")
    payment.pay()
    println("---------------------Check Payment---------------------")
    payment.check()
    println("---------------------Test Payment Again---------------------")
    payment.pay()


//    payment.cancel()

    println("---------------------Process Shipping---------------------")
    shipping.setAddress("118/140 Lumpini Bodindecha route Ramkhamhaeng soi 43/1 Bangkok")
    shipping.requestShipping()
    println("---------------------Check Shipping---------------------")
    shipping.check()

    println("---------------------Complete Order---------------------")
    myOrder.completeOrder()
    myOrder.check()

}
