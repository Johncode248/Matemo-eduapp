package com.lions.anew

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class cls_Mnożenie : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kat_mnozenie)

        val mno2 = findViewById<CardView>(R.id.cart_mnożenie2)
        val mno3 = findViewById<CardView>(R.id.cart_mnożenie3)
        val mno4 = findViewById<CardView>(R.id.cart_mnożenie4)
        val mno5 = findViewById<CardView>(R.id.cart_mnożenie5)
        val mno6 = findViewById<CardView>(R.id.cart_mnożenie6)
        val mno7 = findViewById<CardView>(R.id.cart_mnożenie7)
        val mno8 = findViewById<CardView>(R.id.cart_mnożenie8)
        val mno9 = findViewById<CardView>(R.id.cart_mnożenie9)
        val mno10 = findViewById<CardView>(R.id.cart_mnożenie10)

        val tab50 = findViewById<CardView>(R.id.cart_mnożenie_tab_50)
        val tab100 = findViewById<CardView>(R.id.cart_mnożenie_tab_100)
        val tab200 = findViewById<CardView>(R.id.cart_mnożenie_tab_200)
        val tab500 = findViewById<CardView>(R.id.cart_mnożenie_tab_500)

        val backtomain = findViewById<ImageView>(R.id.imageView4)

        backtomain.setOnClickListener {
            val intent = Intent(this, konta::class.java)
            startActivity(intent)
        }

        mno2.setOnClickListener {
            val intent = Intent(this, Zad_mno_2::class.java)
            startActivity(intent)
        }
        mno3.setOnClickListener {
            val intent = Intent(this, Zad_mno_3::class.java)
            startActivity(intent)
        }
        mno4.setOnClickListener {
            val intent = Intent(this, Zad_mno_4::class.java)
            startActivity(intent)
        }
        mno5.setOnClickListener {
            val intent = Intent(this, Zad_mno_5::class.java)
            startActivity(intent)
        }
        mno6.setOnClickListener {
            val intent = Intent(this, Zad_mno_6::class.java)
            startActivity(intent)
        }
        mno7.setOnClickListener {
            val intent = Intent(this, Zad_mno_7::class.java)
            startActivity(intent)
        }
        mno8.setOnClickListener {
            val intent = Intent(this, Zad_mno_8::class.java)
            startActivity(intent)
        }
        mno9.setOnClickListener {
            val intent = Intent(this, Zad_mno_9::class.java)
            startActivity(intent)
        }
        mno10.setOnClickListener {
            val intent = Intent(this, Zad_mno_10::class.java)
            startActivity(intent)
        }


        //tabliczki
        tab50.setOnClickListener {
            val intent = Intent(this, Zad_mno_tab_50::class.java)
            startActivity(intent)
        }
        tab100.setOnClickListener {
            val intent = Intent(this, Zad_mno_tab_100::class.java)
            startActivity(intent)
        }
        tab200.setOnClickListener {
            val intent = Intent(this, Zad_mno_tab_200::class.java)
            startActivity(intent)
        }
        tab500.setOnClickListener {
            val intent = Intent(this, Zad_mno_tab_500::class.java)
            startActivity(intent)
        }
    }
}