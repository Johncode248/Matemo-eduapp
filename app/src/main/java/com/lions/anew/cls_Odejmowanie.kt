package com.lions.anew

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class cls_Odejmowanie : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kat_odejmowanie)

        val ode10 = findViewById<CardView>(R.id.cart_odejmowanie10)
        val ode20 = findViewById<CardView>(R.id.cart_odejmowanie20)
        val ode30 = findViewById<CardView>(R.id.cart_odejmowanie30)
        val ode50 = findViewById<CardView>(R.id.cart_odejmowanie50)
        val ode100 = findViewById<CardView>(R.id.cart_odejmowanie100)
        val ode300 = findViewById<CardView>(R.id.cart_odejmowanie300)
        val ode600 = findViewById<CardView>(R.id.cart_odejmowanie600)
        val ode1000 = findViewById<CardView>(R.id.cart_odejmowanie1000)

        val ode3liczby = findViewById<CardView>(R.id.cart_odejmowanie_3liczby)
        val ode10do100 = findViewById<CardView>(R.id.cart_odejmowanie_10do100)

        val backtomain = findViewById<ImageView>(R.id.imageView4)

        backtomain.setOnClickListener {
            val intent = Intent(this, konta::class.java)
            startActivity(intent)
        }



        ode10.setOnClickListener {
            val intent = Intent(this, Zad_ode_10::class.java)
            startActivity(intent)
        }
        ode20.setOnClickListener {
            val intent = Intent(this, Zad_ode_20::class.java)
            startActivity(intent)
        }
        ode30.setOnClickListener {
            val intent = Intent(this, Zad_ode_30::class.java)
            startActivity(intent)
        }
        ode50.setOnClickListener {
            val intent = Intent(this, Zad_ode_50::class.java)
            startActivity(intent)
        }
        ode100.setOnClickListener {
            val intent = Intent(this, Zad_ode_100::class.java)
            startActivity(intent)
        }
        ode300.setOnClickListener {
            val intent = Intent(this, Zad_ode_300::class.java)
            startActivity(intent)
        }
        ode600.setOnClickListener {
            val intent = Intent(this, Zad_ode_600::class.java)
            startActivity(intent)
        }
        ode1000.setOnClickListener {
            val intent = Intent(this, Zad_ode_1000::class.java)
            startActivity(intent)
        }
        ode3liczby.setOnClickListener {
            val intent = Intent(this, Zad_ode_3liczby::class.java)
            startActivity(intent)
        }
        ode10do100.setOnClickListener {
            val intent = Intent(this, Zad_ode_10do100::class.java)
            startActivity(intent)
        }

    }
}