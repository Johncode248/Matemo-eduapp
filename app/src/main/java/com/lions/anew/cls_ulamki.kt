package com.lions.anew

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class cls_ulamki : AppCompatActivity() {

    private lateinit var countDownTimer: CountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kat_ulamki)

        val timerTextView = findViewById<TextView>(R.id.textView777)
        val startButton = findViewById<Button>(R.id.button12345)

        // Ustawienie licznika czasu na 1 minutę
        val oneMinute = 60000L

        countDownTimer = object : CountDownTimer(oneMinute, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                // Aktualizacja TextView z licznikiem czasu
                val secondsLeft = millisUntilFinished / 1000
                timerTextView.text = "Czas: $secondsLeft s"
            }

            override fun onFinish() {
                // Zakończenie liczenia czasu i wyświetlenie komunikatu
                timerTextView.text = "Koniec"
            }
        }

        // Uruchomienie licznika czasu po kliknięciu przycisku
        startButton.setOnClickListener {
            countDownTimer.start()
            startButton.visibility = View.INVISIBLE
        }
    }
}