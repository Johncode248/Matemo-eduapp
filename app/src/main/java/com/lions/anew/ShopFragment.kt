package com.lions.anew

import android.app.Dialog
import android.content.ContentValues
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.database.sqlite.SQLiteDatabase
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import kotlin.random.Random


class ShopFragment : Fragment() {

    private val dbHelper by lazy { MyDatabaseHelper(requireContext()) }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_shop, container, false)
        // Inflate the layout for this fragment
        val textViewz : TextView = view.findViewById(R.id.cash)
        val dialogBinding = layoutInflater.inflate(R.layout.open_preznt_layout, null)

        val gradient_prezent = view.findViewById<ImageView>(R.id.imageView)
        val goledn_prezent = view.findViewById<ImageView>(R.id.imageView44)


        // Odczytaj wartość z bazy danych i ustaw ją w TextView
        //-----val db = dbHelper.readableDatabase
        val dbHelper = MyDatabaseHelper(requireContext())
        val db = dbHelper.writableDatabase

        //var count: Int = 0

        var cursor = db.query(TABLE_NAME, arrayOf(COLUMN_NAME_COUNT), null, null, null, null, null)
        if (cursor.moveToFirst()) {
            val count = cursor.getInt(cursor.getColumnIndex(COLUMN_NAME_COUNT))
            textViewz.text = count.toString()
        }
        val myDialog = Dialog(requireContext())
        val set_image1 = dialogBinding.findViewById<ImageView>(R.id.imageView_ser)
        val set_image2 = dialogBinding.findViewById<ImageView>(R.id.imageView_ser2)
        val set_image3 = dialogBinding.findViewById<ImageView>(R.id.imageView_ser3)
        val set_image4 = dialogBinding.findViewById<ImageView>(R.id.imageView_ser4)

        val set_image5 = dialogBinding.findViewById<ImageView>(R.id.imageView_ser5)
        val set_image6 = dialogBinding.findViewById<ImageView>(R.id.imageView_ser6)

        val projection = arrayOf(COLUMN_NAME_DATA)
        val sortOrder = "$COLUMN_NAME_DATA ASC"

        goledn_prezent.setOnClickListener {
            var los_golden = Random.nextInt(1, 3)
            set_image1.visibility = View.INVISIBLE
            set_image2.visibility = View.INVISIBLE
            set_image3.visibility = View.INVISIBLE
            set_image4.visibility = View.INVISIBLE
            set_image5.visibility = View.INVISIBLE
            set_image6.visibility = View.INVISIBLE
            cursor = db.query(TABLE_NAME, arrayOf(COLUMN_NAME_COUNT), null, null, null, null, sortOrder)
            if (cursor.moveToFirst()) {
                var count23 = cursor.getInt(cursor.getColumnIndex(COLUMN_NAME_COUNT))
                if (count23 >= 1000) {
                    println("yes $count23")
                    count23 = count23 - 1000
                    val values = ContentValues().apply {
                        put(COLUMN_NAME_COUNT, count23)
                    }
                    val count22222up = db.update(TABLE_NAME, values, null, null)
                    textViewz.text = count23.toString()
                    //
                    //val myDialog = Dialog(requireContext())
                    cursor = db.query(TABLE_NAME, projection, null, null, null, null, null)


                    los_golden = Random.nextInt(1, 3)

                    if (los_golden == 1) {
                        set_image5.visibility = View.VISIBLE
                        println("1")
                        cursor = db.query(TABLE_NAME, arrayOf(COLUMN_NAME_A4), null, null, null, null, null)
                        if(cursor.moveToFirst())
                            println("1,5")
                        //if (cursor.moveToPosition(2)) { // Przesuń do szóstego wiersza (indeks 5)
                        println("2")
                        val pos2 =
                            cursor.getInt(cursor.getColumnIndex(COLUMN_NAME_A4))
                        val newValue = 3 // Nowa wartość dla szóstego wiersza

                        val values = ContentValues().apply {
                            put(COLUMN_NAME_A4, newValue)
                        }
                        println("3")

                        val whereClause = "$COLUMN_NAME_DATA = ?"
                        val whereArgs = arrayOf(pos2.toString())

                        val rowsAffected = db.update(TABLE_NAME, values, null, null)
                        println("4")

                        if (rowsAffected > 0) {
                            println("5")
                        }

                        //}
                    }

                    if (los_golden == 2) {
                        set_image6.visibility = View.VISIBLE
                        println("1")
                        cursor = db.query(TABLE_NAME, arrayOf(COLUMN_NAME_A5), null, null, null, null, null)
                        if(cursor.moveToFirst())
                            println("1,5")
                        //if (cursor.moveToPosition(2)) { // Przesuń do szóstego wiersza (indeks 5)
                        println("2")
                        val pos2 =
                            cursor.getInt(cursor.getColumnIndex(COLUMN_NAME_A5))
                        val newValue = 3 // Nowa wartość dla szóstego wiersza

                        val values = ContentValues().apply {
                            put(COLUMN_NAME_A5, newValue)
                        }
                        println("3")

                        val whereClause = "$COLUMN_NAME_DATA = ?"
                        val whereArgs = arrayOf(pos2.toString())

                        val rowsAffected = db.update(TABLE_NAME, values, null, null)
                        println("4")

                        if (rowsAffected > 0) {
                            println("5")
                        }

                        //}
                    }

                    myDialog.setContentView(dialogBinding)
                    myDialog.setCancelable(true)
                    myDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                    myDialog.show()

                }
            }
        }



        gradient_prezent.setOnClickListener {
            var photo_to_visible = Random.nextInt(1, 5)
            set_image1.visibility = View.INVISIBLE
            set_image2.visibility = View.INVISIBLE
            set_image3.visibility = View.INVISIBLE
            set_image4.visibility = View.INVISIBLE
            set_image5.visibility = View.INVISIBLE
            set_image6.visibility = View.INVISIBLE
            cursor = db.query(TABLE_NAME, arrayOf(COLUMN_NAME_COUNT), null, null, null, null, sortOrder)
            if (cursor.moveToFirst()) {
                var count23 = cursor.getInt(cursor.getColumnIndex(COLUMN_NAME_COUNT))
                if (count23 >= 200) {
                    println("yes $count23")
                    count23 = count23 - 200
                    val values = ContentValues().apply {
                        put(COLUMN_NAME_COUNT, count23)
                    }
                    val count22222up = db.update(TABLE_NAME, values, null, null)
                    textViewz.text = count23.toString()
                    //
                    //val myDialog = Dialog(requireContext())
                    cursor = db.query(TABLE_NAME, projection, null, null, null, null, null)


                    photo_to_visible = Random.nextInt(1, 5)
                    if (photo_to_visible == 1) {
                        set_image1.visibility = View.VISIBLE
                        println("1")
                        if(cursor.moveToFirst()) {


                            println("1,5")

                            //if (cursor.moveToPosition(2)) { // Przesuń do szóstego wiersza (indeks 5)
                            println("2")
                            val pos2 =
                                cursor.getInt(cursor.getColumnIndex(COLUMN_NAME_DATA))
                            val newValue = 3 // Nowa wartość dla szóstego wiersza

                            val values = ContentValues().apply {
                                put(COLUMN_NAME_DATA, newValue)
                            }
                            println("3")

                            val whereClause = "$COLUMN_NAME_DATA = ?"
                            val whereArgs = arrayOf(pos2.toString())

                            val rowsAffected = db.update(TABLE_NAME, values, null, null)
                            println("4")

                            if (rowsAffected > 0) {
                                println("5")
                            }
                        }
                        //}
                    }
                    if (photo_to_visible == 2) {
                        set_image2.visibility = View.VISIBLE
                        cursor = db.query(TABLE_NAME, arrayOf(COLUMN_NAME_A1), null, null, null, null, sortOrder)
                        if (cursor.moveToFirst()) { // Przesuń do szóstego wiersza (indeks 5)
                            val pos3 =
                                cursor.getInt(cursor.getColumnIndex(COLUMN_NAME_A1))
                            val newValue = 3 // Nowa wartość dla szóstego wiersza

                            val values = ContentValues().apply {
                                put(COLUMN_NAME_A1, newValue)
                            }

                            val whereClause = "$COLUMN_NAME_A1 = ?"
                            val whereArgs = arrayOf(pos3.toString())

                            val rowsAffected = db.update(TABLE_NAME, values, null, null)
                            if (rowsAffected > 0) {
                                println("3")
                            }
                        }
                    }
                    if (photo_to_visible == 3) {
                        set_image3.visibility = View.VISIBLE
                        cursor = db.query(TABLE_NAME, arrayOf(COLUMN_NAME_A2), null, null, null, null, sortOrder)
                        if (cursor.moveToFirst()) { // Przesuń do szóstego wiersza (indeks 5)
                            val pos4 =
                                cursor.getInt(cursor.getColumnIndex(COLUMN_NAME_A2))
                            val newValue = 3 // Nowa wartość dla szóstego wiersza

                            val values = ContentValues().apply {
                                put(COLUMN_NAME_A2, newValue)
                            }

                            val whereClause = "$COLUMN_NAME_DATA = ?"
                            val whereArgs = arrayOf(pos4.toString())

                            val rowsAffected = db.update(TABLE_NAME, values, null, null)
                            if (rowsAffected > 0) {
                                println("4")
                            }
                        }
                    }
                    if (photo_to_visible == 4) {
                        set_image4.visibility = View.VISIBLE
                        cursor = db.query(TABLE_NAME, arrayOf(COLUMN_NAME_A3), null, null, null, null, sortOrder)
                        if (cursor.moveToFirst()) { // Przesuń do szóstego wiersza (indeks 5)
                            val pos5 =
                                cursor.getInt(cursor.getColumnIndex(COLUMN_NAME_A3))
                            val newValue = 3 // Nowa wartość dla szóstego wiersza

                            val values = ContentValues().apply {
                                put(COLUMN_NAME_A3, newValue)
                            }

                            val whereClause = "$COLUMN_NAME_DATA = ?"
                            val whereArgs = arrayOf(pos5.toString())

                            val rowsAffected = db.update(TABLE_NAME, values, null, null)
                            if (rowsAffected > 0) {
                                println("5")
                            }
                        }
                    }
                    myDialog.setContentView(dialogBinding)
                    myDialog.setCancelable(true)
                    myDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                    myDialog.show()

                } else {
                    println("brak srodow")
                }
            }
            ////--++

            cursor.close()
        }

        return view
    }

}

