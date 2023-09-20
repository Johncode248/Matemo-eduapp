package com.lions.anew

import android.app.Dialog
import android.content.ContentValues
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import kotlin.random.Random

class cls_kolejność : AppCompatActivity() {


    private var counter = 0
    private val maxQuestions = 10
    //private val pairs = mutableSetOf<Pair<Int, Int>>()
    private val triplets = ArrayList<Triple<Int, Int, Int>>()

    private val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kat_kolejnosc)



        val btn_x = findViewById<ImageView>(R.id.x_btns)
        val textwyr = findViewById<TextView>(R.id.textView3)
        val textInput = findViewById<EditText>(R.id.edit_wynik)
        val sprawdz_bt = findViewById<Button>(R.id.button_spr)
        val right_result = findViewById<TextView>(R.id.textView_goodresult)
        val tytul_zadanie = findViewById<TextView>(R.id.tytul_zad)
        val popr_odp = findViewById<TextView>(R.id.poprawienie_odp)
        tytul_zadanie.setText("Działania do 100")

        var animation_right = findViewById<LottieAnimationView>(R.id.animationView)
        var animation_wrong = findViewById<LottieAnimationView>(R.id.animationViewincorrect)

        val progressBar = findViewById<ProgressBar>(R.id.progressBar)

        var incorrect = 0
        var corrrect = 0
        var odpowiednia_wartosc = 40

        val dialogBinding = layoutInflater.inflate(R.layout.custom_dialog, null)
        val jeszcze_raz_zad = dialogBinding.findViewById<ImageView>(R.id.again_pls)
        val bt_powrot_z_zadania = dialogBinding.findViewById<ImageView>(R.id.go_head)

        jeszcze_raz_zad.setOnClickListener {
            val intent = Intent(this, cls_kolejność::class.java)
            startActivity(intent)
        }
        bt_powrot_z_zadania.setOnClickListener {
            val intent = Intent(this, konta::class.java)
            startActivity(intent)
        }
        btn_x.setOnClickListener {
            val intent = Intent(this, konta::class.java)
            startActivity(intent)
        }




        generateQuestion(textwyr)

        sprawdz_bt.setOnClickListener {
            val odp = textInput.text.toString()
            val cor = (triplets.elementAt(counter).first + triplets.elementAt(counter).second * triplets.elementAt(counter).third).toString()
            if (odp == cor) {
                right_result.visibility = View.INVISIBLE
                popr_odp.visibility = View.INVISIBLE

                textInput.setText("")
                counter++
                corrrect++
                println("$counter dobra")
                progressBar.progress = (counter * 100) / maxQuestions
                //a
                animation_wrong.visibility = View.INVISIBLE
                animation_right.playAnimation()
                animation_right.visibility = View.VISIBLE

                handler.postDelayed({
                    animation_right.visibility = View.INVISIBLE
                }, 1800)


                if (counter == maxQuestions) {
                    // End of quiz
                    //textwyr.setText("Koniec quizu")
                    textInput.isEnabled = false
                    sprawdz_bt.isEnabled = false

                    odpowiednia_wartosc = 40 - (incorrect * 4)


                    // Otwarcie bazy danych
                    val dbHelper = MyDatabaseHelper(this)
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
                    val newCount = count + odpowiednia_wartosc
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

                    //Alert Dialog
                    //xxxxxxxval dialogBinding = layoutInflater.inflate(R.layout.custom_dialog,null)
                    //znaleziono text view z layout Alert dialog
                    val zmienna_blednie = dialogBinding.findViewById<TextView>(R.id.alert_message2)
                    val zmienna_poprawnie = dialogBinding.findViewById<TextView>(R.id.alert_message)
                    val cash_get = dialogBinding.findViewById<TextView>(R.id.cashh)

                    zmienna_poprawnie.setText("$corrrect")
                    zmienna_blednie.setText("$incorrect")
                    cash_get.setText("$odpowiednia_wartosc")


                    //Dialog Alert -
                    val myDialog = Dialog(this)
                    myDialog.setContentView(dialogBinding)
                    myDialog.setCancelable(true)
                    myDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                    myDialog.show()


                } else {
                    //stwórz kolejne zadanie jesli jeszcze nie zrobiłes wymaganej ilości

                    generateQuestion(textwyr)
                }
            } else {
                //zła odpowiedź
                incorrect++

                counter++
                progressBar.progress = (counter * 100) / maxQuestions

                println("$counter zła")
                //a
                animation_wrong.playAnimation()
                animation_wrong.visibility = View.VISIBLE
                textInput.setText("")
                var x111 = textwyr.text
                right_result.setText("$x111 $odp")
                right_result.visibility = View.VISIBLE
                popr_odp.setText("$x111 $cor")
                popr_odp.visibility = View.VISIBLE
                generateQuestion(textwyr)

                //Dodano

                if (counter == maxQuestions) {
                    // End of quiz
                    //textwyr.setText("Koniec quizu")
                    textInput.isEnabled = false
                    sprawdz_bt.isEnabled = false

                    odpowiednia_wartosc = 40 - (incorrect * 4)


                    // Otwarcie bazy danych
                    val dbHelper = MyDatabaseHelper(this)
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
                    val newCount = count + odpowiednia_wartosc
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

                    //Alert Dialog
                    //xxxxxxxval dialogBinding = layoutInflater.inflate(R.layout.custom_dialog,null)
                    //znaleziono text view z layout Alert dialog
                    val zmienna_blednie = dialogBinding.findViewById<TextView>(R.id.alert_message2)
                    val zmienna_poprawnie = dialogBinding.findViewById<TextView>(R.id.alert_message)
                    val cash_get = dialogBinding.findViewById<TextView>(R.id.cashh)

                    zmienna_poprawnie.setText("$corrrect")
                    zmienna_blednie.setText("$incorrect")
                    cash_get.setText("$odpowiednia_wartosc")


                    //Dialog Alert -
                    val myDialog = Dialog(this)
                    myDialog.setContentView(dialogBinding)
                    myDialog.setCancelable(true)
                    myDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                    myDialog.show()


                    //
                    //handler.postDelayed({
                    //    animation_wrong.visibility = View.INVISIBLE
                    //}, 2200)

                }
            }
        }
    }

    fun generateQuestion(textwyr: TextView) {
        var triplet: Triple<Int, Int, Int>
        do {
            var x1 = Random.nextInt(1, 50)
            var x2 = Random.nextInt(1, 50)
            var x3 = Random.nextInt(1, 50)

            while (x2 * x3 + x1 > 100) {
                x1 = Random.nextInt(1, 50)
                x2 = Random.nextInt(1, 50)
                x3 = Random.nextInt(1, 50)
            }

            triplet = Triple(x1, x2, x3)
        } while (triplets.contains(triplet))
        triplets.add(triplet)
        textwyr.setText("${triplet.first} + ${triplet.second} × ${triplet.third} =")
    }
}