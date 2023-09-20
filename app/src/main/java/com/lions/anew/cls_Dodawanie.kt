package com.lions.anew

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class cls_Dodawanie : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kat_dodawanie)



        val dod10 = findViewById<CardView>(R.id.cart_dodawanie10)
        val dod20 = findViewById<CardView>(R.id.cart_dodawaniedo20)
        val dod30 = findViewById<CardView>(R.id.cart_dodawanie30)
        val dod50 = findViewById<CardView>(R.id.cart_dodawanie50)
        val dod100  = findViewById<CardView>(R.id.cart_dodawanie100)
        val dod300  = findViewById<CardView>(R.id.cart_dodawanie300)
        val dod500  = findViewById<CardView>(R.id.cart_dodawanie700)
        val dod1000  = findViewById<CardView>(R.id.cart_dodawanie1000)

        val dod10do100 = findViewById<CardView>(R.id.cart_dodawanie_dziesiątek_100)
        val dod3liczby = findViewById<CardView>(R.id.cart_dodawanie_3liczby)

        val backtomain = findViewById<ImageView>(R.id.imageView4)

        backtomain.setOnClickListener {
            val intent = Intent(this, konta::class.java)
            startActivity(intent)
        }


        dod10.setOnClickListener {
            val intent = Intent(this, Zad_dod_10::class.java)
            startActivity(intent)
        }

        dod20.setOnClickListener {
            val intent = Intent(this, Zad_dod_20::class.java)
            startActivity(intent)
        }

        dod30.setOnClickListener {
            val intent = Intent(this, Zad_dod_30::class.java)
            startActivity(intent)
        }

        dod50.setOnClickListener {
            val intent = Intent(this, Zad_dod_50::class.java)
            startActivity(intent)
        }
        dod100.setOnClickListener {
            val intent = Intent(this, Zad_1::class.java)
            startActivity(intent)
        }
        dod300.setOnClickListener {
            val intent = Intent(this, Zad_dod_300::class.java)
            startActivity(intent)
        }
        dod500.setOnClickListener {
            val intent = Intent(this, Zad_dod_500::class.java)
            startActivity(intent)
        }
        dod1000.setOnClickListener {
            val intent = Intent(this, Zad_dod_1000::class.java)
            startActivity(intent)
        }
        dod10do100.setOnClickListener {
            val intent = Intent(this, Zad_dod_10do100::class.java)
            startActivity(intent)
        }
        dod3liczby.setOnClickListener {
            val intent = Intent(this, Zad_dod_3liczby::class.java)
            startActivity(intent)
        }
    }
}