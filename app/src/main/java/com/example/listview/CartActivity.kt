package com.example.listview

import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_custom_list_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val listView = findViewById<ListView>(R.id.lvCartList)
        // set drawwable to something else that makes sense --> R.drawable.image1
        val cartItems = listOf(
            CartItem(R.drawable.ic_launcher_foreground, "Gaming", 100.0),
            CartItem(R.drawable.ic_launcher_foreground, "Work", 200.0),
            CartItem(R.drawable.ic_launcher_foreground, "Office", 300.0)
        )

        val arrayAdapter = CartCustomListViewAdapter(
            this,
            cartItems,
            onClick = {
                Toast.makeText(
                    this,
                    "Clicked on ${it.name} with price ${it.subTotal}",
                    Toast.LENGTH_SHORT
                ).show()
            })
        listView.adapter = arrayAdapter
    }
}