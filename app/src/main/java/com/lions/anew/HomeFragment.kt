package com.lions.anew

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.FragmentTransaction
import java.util.Locale



class HomeFragment : Fragment() {

    //private val dbHelper = MyDatabaseHelper(this)
    private val dbHelper by lazy { MyDatabaseHelper(requireActivity()) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val imagess: ImageView = view.findViewById(R.id.imageView333)

        //carty
        val c_dodawanie: CardView = view.findViewById(R.id.cart_dodawanie)
        val c_odejmowanie: CardView = view.findViewById(R.id.cart_odejmowanie)
        val c_mnożenie: CardView = view.findViewById(R.id.cart_mnożenie)
        val c_dzielenie: CardView = view.findViewById(R.id.cart_dzielenie)
        val c_kolejność: CardView = view.findViewById(R.id.cart_kolejność)
        val c_równania: CardView = view.findViewById(R.id.cart_równania)
        val c_ulamki: CardView = view.findViewById(R.id.cart_ułamki)
        val c_testy: CardView = view.findViewById(R.id.cart_testy)

        val textViewz : TextView = view.findViewById(R.id.cash)


        //carty

        // Odczytaj wartość z bazy danych i ustaw ją w TextView
        val db = dbHelper.readableDatabase
        val cursor = db.query(TABLE_NAME, arrayOf(COLUMN_NAME_COUNT), null, null, null, null, null)
        if (cursor.moveToFirst()) {
            val count = cursor.getInt(cursor.getColumnIndex(COLUMN_NAME_COUNT))
            textViewz.text = count.toString()
        }
        cursor.close()

        // Pobranie aktualnej wartości z bazy danych
        /*
        val cursor12 = db.query(TABLE_NAME, arrayOf(Language),null,null,null,null,null,null)
        cursor.moveToFirst()
        val count = cursor12.getInt(cursor12.getColumnIndex(Language))

        if (count == 0) {

            println("polish start")
        }

        if (count == 1) {

            println("english start")
        }
        if (count == 2) {

            println("ukr start")
        }
        cursor12.close()


         */


        val iccc: ImageView = view.findViewById(R.id.ic_konto)

        iccc.setOnClickListener {
            val intent = Intent(activity, Profil::class.java)
            startActivity(intent)
        }
        //włączanie kart
        c_dodawanie.setOnClickListener {
            val intent = Intent(activity, cls_Dodawanie::class.java)
            startActivity(intent)
        }
        c_odejmowanie.setOnClickListener {
            val intent = Intent(activity, cls_Odejmowanie::class.java)
            startActivity(intent)
        }
        c_mnożenie.setOnClickListener {
            val intent = Intent(activity, cls_Mnożenie::class.java)
            startActivity(intent)
        }
        c_dzielenie.setOnClickListener {
            val intent = Intent(activity, cls_dzielenie::class.java)
            startActivity(intent)
        }
        c_kolejność.setOnClickListener {
            val intent = Intent(activity, cls_kolejność::class.java)
            startActivity(intent)
        }
        c_równania.setOnClickListener {
            val intent = Intent(activity, cls_równania::class.java)
            startActivity(intent)
        }
        c_ulamki.setOnClickListener {
            val intent = Intent(activity, cls_ulamki::class.java)
            startActivity(intent)
        }
        c_testy.setOnClickListener {
            val intent = Intent(activity, cls_testy::class.java)
            startActivity(intent)
        }


        //////////////////////////////////////////

        return view
    }




}











