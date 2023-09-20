package com.lions.anew

import android.app.Dialog
import android.content.ContentValues
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

import kotlin.random.Random

class cls_testy : AppCompatActivity() {

        private lateinit var textView1: TextView
        private lateinit var textView2: TextView
        private lateinit var textView3: TextView
        private lateinit var textView4: TextView
    private lateinit var textView12: TextView
    private lateinit var textView_cash: TextView

    //---constraint_Layouts
    private lateinit var Con1: ConstraintLayout
    private lateinit var Con2: ConstraintLayout
    private lateinit var Con3: ConstraintLayout
    private lateinit var Con4: ConstraintLayout
    //---constraint_Layouts

    private lateinit var countDownTimer: CountDownTimer

    private var iloscpop = 0
    private var ilosczle = 0

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.kat_testy)

            var widok_niewidzialny = findViewById<ConstraintLayout>(R.id.niewidka)
            textView1 = findViewById(R.id.textView1s)
            textView2 = findViewById(R.id.textView2s)
            textView3 = findViewById(R.id.textView3s)
            textView4 = findViewById(R.id.textView4s)
            textView12 = findViewById(R.id.textView12s)
            textView_cash = findViewById(R.id.textView_cash)
            val progress_tick = findViewById<ProgressBar>(R.id.progressBar_ticktock)

            Con1 = findViewById(R.id.cons1)
            Con2 = findViewById(R.id.cons2)
            Con3 = findViewById(R.id.cons3)
            Con4 = findViewById(R.id.cons4)

            val timerTextView = findViewById<TextView>(R.id.textView9)



            val dialogBinding = layoutInflater.inflate(R.layout.custom_dialog_tick, null)

            //btn
            val start_btn = findViewById<Button>(R.id.Start_Now)
            //btn
            start_btn.setOnClickListener {
                widok_niewidzialny.visibility = View.VISIBLE
                start_btn.visibility = View.INVISIBLE
                shuffleTextView()
                countDownTimer.start()
            }


            // Ustawienie licznika czasu na ...1 minutę (1minuta = 60000, 30s = 30000)
            val oneMinute = 30000L

            var progress_ti = 30

            countDownTimer = object : CountDownTimer(oneMinute, 1000) {

                override fun onTick(millisUntilFinished: Long) {
                    // Aktualizacja TextView z licznikiem czasu
                    val secondsLeft = millisUntilFinished / 1000
                    timerTextView.text = "Czas: $secondsLeft s"
                    progress_ti--

                    progress_tick.progress = progress_ti
                }

                override fun onFinish() {
                    // Zakończenie liczenia czasu i wyświetlenie komunikatu
                    timerTextView.text = "Koniec"
                    textView1.visibility = View.INVISIBLE
                    textView2.visibility = View.INVISIBLE
                    textView3.visibility = View.INVISIBLE
                    textView4.visibility = View.INVISIBLE
                    textView_cash.setText("$iloscpop")
                    println("dobrze $iloscpop")
                    println("zle $ilosczle")

                    val myDialog = Dialog(this@cls_testy)
                    //val wynik_procentowy: Int = (iloscpop /(iloscpop + ilosczle)) * 100
                    //var procent_text = myDialog.findViewById<TextView>(R.id.percent)
                    //procent_text.setText("$wynik_procentowy")

                    myDialog.setContentView(dialogBinding)
                    myDialog.setCancelable(false)
                    myDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                    myDialog.show()





                    // Otwarcie bazy danych
                    val dbHelper = MyDatabaseHelper(this@cls_testy)
                    val db = dbHelper.writableDatabase

                    // Pobranie aktualnej wartości z bazy danych
                    val cursor = db.query(
                        TABLE_NAME,
                        arrayOf(COLUMN_NAME_COUNT),
                        null,
                        null,
                        null,
                        null,
                        null
                    )
                    cursor.moveToFirst()
                    val count = cursor.getInt(cursor.getColumnIndex(COLUMN_NAME_COUNT))

                    // Zwiększenie wartości o 5 i zapisanie do bazy danych
                    val newCount = count + iloscpop
                    val values = ContentValues().apply {
                        put(COLUMN_NAME_COUNT, newCount)
                    }
                    db.update(TABLE_NAME, values, null, null)

                    // Przekazanie nowej wartości do poprzedniej aktywności
                    val intent = Intent().apply {
                        putExtra("newCount", newCount)
                    }
                    setResult(RESULT_OK, intent)

                    // Zamknięcie bazy danych i aktywności
                    cursor.close()
                    //db.close()
                    //finish()
                    //Baza Danych
                }
            }







        }

        private fun shuffleTextView() {

            var x1 = Random.nextInt(1,25)
            var x2 = Random.nextInt(1,25)
            var resultx: Int = x1 + x2


            val values = mutableListOf(resultx, Random.nextInt(1, 30), Random.nextInt(1, 30), Random.nextInt(1, 30))
            values.shuffle()

            val index = Random.nextInt(0, 4)
            val value6 = values[index]
            values.removeAt(index)

            textView1.text = values[0].toString()
            textView2.text = values[1].toString()
            textView3.text = values[2].toString()
            textView4.text = value6.toString()

            textView12.setText("$x1 + $x2 = ")

            Con1.setOnClickListener {
                if (textView1.text == resultx.toString()) {
                    shuffleTextView()
                    iloscpop++
                } else {
                    shuffleTextView()
                    ilosczle++
                }
            }

            Con2.setOnClickListener {
                if (textView2.text == resultx.toString()) {
                    shuffleTextView()
                    iloscpop++
                } else {
                    shuffleTextView()
                    ilosczle++
                }
            }

            Con3.setOnClickListener {
                if (textView3.text == resultx.toString()) {
                    shuffleTextView()
                    iloscpop++
                } else { shuffleTextView()
                    ilosczle++}
            }

            Con4.setOnClickListener {
                if (textView4.text == resultx.toString()) {
                    shuffleTextView()
                    iloscpop++
                } else {shuffleTextView()
                    ilosczle++ }
            }


            while(textView1.text == textView2.text || textView1.text == textView3.text || textView1.text == textView4.text || textView2.text == textView3.text || textView3.text == textView4.text || textView4.text == textView2.text) {

                val values = mutableListOf(resultx, Random.nextInt(1, 30), Random.nextInt(1, 30), Random.nextInt(1, 30))
                values.shuffle()

                val index = Random.nextInt(0, 4)
                val value6 = values[index]
                values.removeAt(index)

                textView1.text = values[0].toString()
                textView2.text = values[1].toString()
                textView3.text = values[2].toString()
                textView4.text = value6.toString()

            }
            Con1.setOnClickListener {
                if (textView1.text == resultx.toString()) {
                    shuffleTextView()
                    iloscpop++
                } else {shuffleTextView()
                    ilosczle++ }
            }

            Con2.setOnClickListener {
                if (textView2.text == resultx.toString()) {
                    shuffleTextView()
                    iloscpop++
                } else {shuffleTextView()
                    ilosczle++ }
            }

            Con3.setOnClickListener {
                if (textView3.text == resultx.toString()) {
                    shuffleTextView()
                    iloscpop++
                } else {shuffleTextView()
                    ilosczle++ }
            }

            Con4.setOnClickListener {
                if (textView4.text == resultx.toString()) {
                    shuffleTextView()
                    iloscpop++
                } else { shuffleTextView()
                    ilosczle++}
            }
        }
    }

