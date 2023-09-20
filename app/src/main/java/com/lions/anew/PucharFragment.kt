package com.lions.anew

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView


class PucharFragment : Fragment() {

    //private val dbHelper by lazy { MyDatabaseHelper(requireActivity()) }
    //private val dbHelper by lazy { MyDatabaseHelper(requireActivity()) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_puchar, container, false)
        // Inflate the layout for this fragment
        //val newData = dbHelper.getDataFromDatabase()

        val jezyk = view.findViewById<ImageView>(R.id.c_jezyk)
        val fox = view.findViewById<ImageView>(R.id.c_fox)
        val girafe = view.findViewById<ImageView>(R.id.c_girafe)
        val pinguin = view.findViewById<ImageView>(R.id.c_pinguin)
        val rabbit = view.findViewById<ImageView>(R.id.c_rabbit)
        val lion = view.findViewById<ImageView>(R.id.c_lion)

        val dbHelper = MyDatabaseHelper(requireContext())
        val db = dbHelper.writableDatabase

        val projection = arrayOf(COLUMN_NAME_DATA)
        val sortOrder = "$COLUMN_NAME_DATA ASC" // Zakładając, że kolumna ID jest używana do sortowania

        var cursor = db.query(TABLE_NAME, projection, null, null, null, null, null)

// Przesuń kursor do początkowej pozycji

        if (cursor.moveToFirst()) {
            val pierwszyWierszData = cursor.getInt(cursor.getColumnIndex(COLUMN_NAME_DATA))
            // Wykonaj operacje na wartości z pierwszego wiersza
            if (pierwszyWierszData == 3) {
                lion.visibility = View.VISIBLE
            } else {
                println("no2")
            }
        }
        cursor = db.query(TABLE_NAME, arrayOf(COLUMN_NAME_A1) , null, null, null, null, null)
        if (cursor.moveToFirst()) {
            val drugiWierszData = cursor.getInt(cursor.getColumnIndex(COLUMN_NAME_A1))
            if (drugiWierszData == 3) {
                fox.visibility = View.VISIBLE
            } else {
                println("no 3")
            }
        }
            cursor = db.query(TABLE_NAME, arrayOf(COLUMN_NAME_A2) , null, null, null, null, null)

        if (cursor.moveToFirst()) {
            val trzeciWierszData = cursor.getInt(cursor.getColumnIndex(COLUMN_NAME_A2))
            // Wykonaj operacje na wartości z pierwszego wiersza
            if (trzeciWierszData == 3) {
                rabbit.visibility = View.VISIBLE
            } else {
                println("no2")
            }
        }
        cursor = db.query(TABLE_NAME, arrayOf(COLUMN_NAME_A3) , null, null, null, null, null)
        if (cursor.moveToFirst()) {
            val czwartyWierszData = cursor.getInt(cursor.getColumnIndex(COLUMN_NAME_A3))
                // Wykonaj operacje na wartości z pierwszego wiersza
            if (czwartyWierszData == 3) {
                girafe.visibility = View.VISIBLE
            } else {
                println("no2")
            }
        }
        cursor = db.query(TABLE_NAME, arrayOf(COLUMN_NAME_A4) , null, null, null, null, null)
        if (cursor.moveToFirst()) {
            val piatyWierszData = cursor.getInt(cursor.getColumnIndex(COLUMN_NAME_A4))
            // Wykonaj operacje na wartości z pierwszego wiersza
            if (piatyWierszData == 3) {
                pinguin.visibility = View.VISIBLE
            } else {
                println("no2")
            }
        }
        cursor = db.query(TABLE_NAME, arrayOf(COLUMN_NAME_A5) , null, null, null, null, null)
        if (cursor.moveToFirst()) {
            val szostyWierszData = cursor.getInt(cursor.getColumnIndex(COLUMN_NAME_A5))
            // Wykonaj operacje na wartości z pierwszego wiersza
            if (szostyWierszData == 3) {
                jezyk.visibility = View.VISIBLE
            } else {
                println("no2")
            }
        }



        cursor.close()

        return view
    }
}



