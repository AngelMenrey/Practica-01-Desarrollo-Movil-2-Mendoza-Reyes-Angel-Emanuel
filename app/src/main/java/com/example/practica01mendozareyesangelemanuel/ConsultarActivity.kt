package com.example.practica01mendozareyesangelemanuel

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationManagerCompat

class ConsultarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consultar)

        NotificationManagerCompat.from(this).apply {
            cancel(MenuActivity.notificationId)
        }

        setSupportActionBar(findViewById(R.id.barraConsultar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val nombreProducto = intent.getStringExtra("nombre del producto")
        val precio = intent.getStringExtra("precio")
        val categoria = intent.getStringExtra("categoria")
        val marca = intent.getStringExtra("marca")

        val textView = findViewById<TextView>(R.id.textView)
        textView.text = "Nombre del Producto: $nombreProducto\nPrecio: $precio\nCategoría: $categoria\nMarca: $marca"
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            val intent = Intent(this, MenuActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }
            startActivity(intent)
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
