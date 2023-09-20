package com.lions.anew

import android.content.ContentValues
import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale
import android.content.res.Configuration
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast

class Profil : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profil_widok)

        val text_policy = findViewById<TextView>(R.id.textView_privacy)
        val back = findViewById<ImageView>(R.id.imageView4_back)

        val dbHelper = MyDatabaseHelper(this)
        val db = dbHelper.writableDatabase


        back.setOnClickListener {
            val intent = Intent(this, konta::class.java)
            startActivity(intent)
        }
        val rekbtn = findViewById<TextView>(R.id.textView21_rek)
        rekbtn.setOnClickListener {
            val intent = Intent(this, Reklass::class.java)
            startActivity(intent)
        }

        //btn_2rek{


        text_policy.setOnClickListener {
            val url = "https://www.iubenda.com/privacy-policy/95594354"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }


        val enButton = findViewById<View>(R.id.enbutton)
        enButton.setOnClickListener {
            setAppLocale("en")
            //val newLanguage = "en" // Ustaw język, na który chcesz zmienić
            //-


            // Pobranie aktualnej wartości z bazy danych
            val cursor = db.query(
                TABLE_NAME,
                arrayOf(Language),
                null,
                null,
                null,
                null,
                null
            )
            cursor.moveToFirst()
            val count = cursor.getInt(cursor.getColumnIndex(Language))

            // Zwiększenie wartości o 5 i zapisanie do bazy danych
            val newCount = 1
            val values = ContentValues().apply {
                put(Language, newCount)
            }
            db.update(TABLE_NAME, values, null, null)
            //--


            recreate()
        }
        val pl_btn = findViewById<Button>(R.id.button_pl)
        pl_btn.setOnClickListener {
            setAppLocale("pl")
            //val newLanguage = "en" // Ustaw język, na który chcesz zmienić
            //-


            // Pobranie aktualnej wartości z bazy danych
            val cursor = db.query(
                TABLE_NAME,
                arrayOf(Language),
                null,
                null,
                null,
                null,
                null
            )
            cursor.moveToFirst()
            val count = cursor.getInt(cursor.getColumnIndex(Language))

            // Zwiększenie wartości o 5 i zapisanie do bazy danych
            val newCount = 0
            val values = ContentValues().apply {
                put(Language, newCount)
            }
            db.update(TABLE_NAME, values, null, null)
            //--

            recreate()
        }

        val ukr_btn = findViewById<Button>(R.id.button_ukr)
        ukr_btn.setOnClickListener {
            setAppLocale("uk")


            // Pobranie aktualnej wartości z bazy danych
            val cursor = db.query(
                TABLE_NAME,
                arrayOf(Language),
                null,
                null,
                null,
                null,
                null
            )
            cursor.moveToFirst()
            val count = cursor.getInt(cursor.getColumnIndex(Language))


            val newCount = 2
            val values = ContentValues().apply {
                put(Language, newCount)
            }
            db.update(TABLE_NAME, values, null, null)
            //--

            recreate()
        }


         /*


        val spinner: Spinner = findViewById(R.id.spinner)
        val options = arrayOf("Polski", "English","Ukrainian")

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, options)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        //
        val cursor = db.query(
            TABLE_NAME,
            arrayOf(Language),
            null,
            null,
            null,
            null,
            null
        )
        cursor.moveToFirst()
        val count = cursor.getInt(cursor.getColumnIndex(Language))
        //

          */



        /*
        if (count == 0){
            spinner.setSelection(0)
        }
        if (count == 1){
            spinner.setSelection(1)
        }
        if (count == 2){
            spinner.setSelection(2)
        }
        /
         */

        /*
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {


            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

                when (position) {
                    0 ->
                    {
                        //Toast.makeText(applicationContext, "1", Toast.LENGTH_SHORT).show()
                        setAppLocale("pl")

                        // Pobranie aktualnej wartości z bazy danych
                        val cursor = db.query(
                            TABLE_NAME,
                            arrayOf(Language),
                            null,
                            null,
                            null,
                            null,
                            null
                        )
                        cursor.moveToFirst()
                        val count = cursor.getInt(cursor.getColumnIndex(Language))


                        val newCount = 1
                        val values = ContentValues().apply {
                            put(Language, newCount)
                        }
                        db.update(TABLE_NAME, values, null, null)
                        //--

                        //kod zapisywania baza danych



                    }
                    1 -> {
                        //Toast.makeText(applicationContext, "2", Toast.LENGTH_SHORT).show()
                        setAppLocale("en")
                        // Pobranie aktualnej wartości z bazy danych
                        val cursor = db.query(
                            TABLE_NAME,
                            arrayOf(Language),
                            null,
                            null,
                            null,
                            null,
                            null
                        )
                        cursor.moveToFirst()
                        val count = cursor.getInt(cursor.getColumnIndex(Language))


                        val newCount = 2
                        val values = ContentValues().apply {
                            put(Language, newCount)
                        }
                        db.update(TABLE_NAME, values, null, null)
                        //--


                    }
                    2 -> {
                        setAppLocale("uk")
                        // Pobranie aktualnej wartości z bazy danych
                        val cursor = db.query(
                            TABLE_NAME,
                            arrayOf(Language),
                            null,
                            null,
                            null,
                            null,
                            null
                        )
                        cursor.moveToFirst()
                        val count = cursor.getInt(cursor.getColumnIndex(Language))


                        val newCount = 2
                        val values = ContentValues().apply {
                            put(Language, newCount)
                        }
                        db.update(TABLE_NAME, values, null, null)



                    }

                }
                //recreate()
            }


            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Wywołane, gdy nie została wybrana żadna pozycja.
            }

        }

         */


    }


    private fun setAppLocale(localeCode: String) {

        val locale = Locale(localeCode)
        Locale.setDefault(locale)
        val resources: Resources = baseContext.resources
        val configuration: Configuration = resources.configuration
        configuration.setLocale(locale)
        resources.updateConfiguration(configuration, resources.displayMetrics)
    }


}



