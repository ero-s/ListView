package com.example.listview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class CartCustomListViewAdapter(
    private val context: Context,
    private val cartItems: List<CartItem>,
    private val onClick: (CartItem) -> Unit
) : BaseAdapter() {
    override fun getCount(): Int = cartItems.size

    override fun getItem(pos: Int): Any = cartItems[pos]

    override fun getItemId(pos: Int): Long = pos.toLong()

    override fun getView(pos: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(
            R.layout.activity_custom_list_view,
            parent,
            false
        )

        val img = view.findViewById<ImageView>(R.id.ivCartItemImage)
        val text = view.findViewById<TextView>(R.id.tvCartItemName)
        val price = view.findViewById<TextView>(R.id.tvCartItemSubtotal)

        val cartItem = cartItems[pos]

        img.setImageResource(cartItem.image)
        text.text = cartItem.name
        price.text = cartItem.subTotal.toString()

        view.setOnClickListener { onClick(cartItem) }

        return view
    }

}