package com.lions.anew

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintLayout
import com.airbnb.lottie.LottieAnimationView
import java.util.Locale

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val clickme = findViewById<Button>(R.id.button1)
        val layoutmain = findViewById<ConstraintLayout>(R.id.bbbb)

        layoutmain.setOnClickListener{
            val Intent = Intent(this,konta::class.java)
            startActivity(Intent)
        }


        Thread.sleep(800)
        val Intent = Intent(this,konta::class.java)
        startActivity(Intent)
    }


    private fun setAppLocale(localeCode: String) {
        val locale = Locale(localeCode)
        Locale.setDefault(locale)

        val config = Configuration()
        config.setLocale(locale)

        baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)
    }
}