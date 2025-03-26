package com.example.listview

import androidx.annotation.DrawableRes

data class CartItem(
    @DrawableRes var image: Int,
    var name: String = "",
    var subTotal: Double = 0.0
)
