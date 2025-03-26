package com.example.listview

import androidx.annotation.DrawableRes

data class CartItem(
    @DrawableRes var image: Int = R.drawable.ic_launcher_foreground,
    var name: String = "",
    var subTotal: Double = 0.0
)
