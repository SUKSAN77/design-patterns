package mediator

import Restaurant

interface RestaurantMediator {
    fun notify(sender: Restaurant, msg: String)
}