package com.lions.anew

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class cls_dzielenie : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kat_dzielenie)

        val dziel2 = findViewById<CardView>(R.id.cart_dzielenie2)
        val dziel3 = findViewById<CardView>(R.id.cart_dzielenie3)
        val dziel4 = findViewById<CardView>(R.id.cart_dzielenie4)
        val dziel5 = findViewById<CardView>(R.id.cart_dzielenie5)
        val dziel6 = findViewById<CardView>(R.id.cart_dzielenie6)
        val dziel7 = findViewById<CardView>(R.id.cart_dzielenie7)
        val dziel8 = findViewById<CardView>(R.id.cart_dzielenie8)
        val dziel9 = findViewById<CardView>(R.id.cart_dzielenie9)
        val dziel10 = findViewById<CardView>(R.id.cart_dzielenie10)

        val tab_50 = findViewById<CardView>(R.id.cart_dzielenie_tab_50)
        val tab_100 = findViewById<CardView>(R.id.cart_dzielenie_tab_100)
        val tab_200 = findViewById<CardView>(R.id.cart_dzielenie_tab_200)
        val tab_500 = findViewById<CardView>(R.id.dzielenie_tab_500)

        val backtomain = findViewById<ImageView>(R.id.imageView4)

        backtomain.setOnClickListener {
            val intent = Intent(this, konta::class.java)
            startActivity(intent)
        }



        dziel2.setOnClickListener {
            val intent = Intent(this, Zad_dziel_2::class.java)
            startActivity(intent)
        }
        dziel3.setOnClickListener {
            val intent = Intent(this, Zad_dziel_3::class.java)
            startActivity(intent)
        }
        dziel4.setOnClickListener {
            val intent = Intent(this, Zad_dziel_4::class.java)
            startActivity(intent)
        }
        dziel5.setOnClickListener {
            val intent = Intent(this, Zad_dziel_5::class.java)
            startActivity(intent)
        }
        dziel6.setOnClickListener {
            val intent = Intent(this, Zad_dziel_6::class.java)
            startActivity(intent)
        }
        dziel7.setOnClickListener {
            val intent = Intent(this, Zad_dziel_7::class.java)
            startActivity(intent)
        }
        dziel8.setOnClickListener {
            val intent = Intent(this, Zad_dziel_8::class.java)
            startActivity(intent)
        }
        dziel9.setOnClickListener {
            val intent = Intent(this, Zad_dziel_9::class.java)
            startActivity(intent)
        }
        dziel10.setOnClickListener {
            val intent = Intent(this, Zad_dziel_10::class.java)
            startActivity(intent)
        }

        //tabliczki
        tab_50.setOnClickListener {
            val intent = Intent(this, Zad_dziel_tab_50::class.java)
            startActivity(intent)
        }
        tab_100.setOnClickListener {
            val intent = Intent(this, Zad_dziel_tab_100::class.java)
            startActivity(intent)
        }
        tab_200.setOnClickListener {
            val intent = Intent(this, Zad_dziel_tab_200::class.java)
            startActivity(intent)
        }
        tab_500.setOnClickListener {
            val intent = Intent(this, Zad_dziel_tab_500::class.java)
            startActivity(intent)
        }
    }
}