package com.axel.foodie.model.data

import com.axel.foodie.R
import com.axel.foodie.model.Slide

class SampleData {
    companion object{
        val slideItems = listOf(
            Slide(
                title = "Order",
                description = "Order all you want from\nyour favourite stores",
                image = R.drawable.order_slide
            ),
            Slide(
                title = "Pick Delivery Time",
                description = "Receive your order in less than\n1hour or pick a specific delivery time",
                image = R.drawable.pick_slide
            ),
            Slide(
                title = "Get Your Order",
                description = "Real-time tracking will keep you\nPosted about order progress",
                image = R.drawable.get_slider
            )
        )
    }
}