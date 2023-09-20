package com.lions.anew


import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.DialogInterface
import android.content.Intent
import android.content.res.Configuration
import android.content.res.Resources
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.text.TextUtils.replace
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import java.util.Locale
import android.app.AlertDialog


class konta : AppCompatActivity() {


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.konta_main)

        val homeFragment = HomeFragment()
        val shopFragment = ShopFragment()
        //val statsFragment = StatsFragment()
        val pucharFragment = PucharFragment()
        val bottom_navig = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val xxx = findViewById<ImageView>(R.id.imageView333)





        //val kwota = findViewById<TextView>(R.id.cash)
        var zmienna = 0
        //var zmienna2 = 0







        //fm.beginTransaction().add(R.id.drawer_layout,homeFragment).commit()
        makeCurrnetFragment(homeFragment)

        bottom_navig.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.ic_home -> makeCurrnetFragment(homeFragment)
                R.id.ic_shop -> makeCurrnetFragment(shopFragment)
                //R.id.ic_stats -> makeCurrnetFragment(statsFragment)
                R.id.ic_puchar -> makeCurrnetFragment(pucharFragment)
            }
            true
        }
        //xxx.setOnClickListener {
        //ShopFragment()
    //}
        //--
        val dbHelper = MyDatabaseHelper(this)
        val db = dbHelper.writableDatabase

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



        //ZMIENNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN LOCALNY JEZYK setApLocale("")
        // Zwiększenie wartości o 5 i zapisanie do bazy danych
        if (count == 1) { setAppLocale("en")}
        if (count == 2) { setAppLocale("uk")}
        if (count == 3) { setAppLocale("uk")}
        if (count == 4) { setAppLocale("uk")}
        if (count == 5) { setAppLocale("uk")}
        if (count == 6) { setAppLocale("uk")}
        if (count == 7) { setAppLocale("uk")}
        if (count == 8) { setAppLocale("uk")}
        if (count == 9) { setAppLocale("uk")}
        if (count == 10) { setAppLocale("uk")}
        if (count == 11) { setAppLocale("uk")}
        if (count == 12) { setAppLocale("uk")}
        if (count == 13) { setAppLocale("uk")}
        if (count == 14) { setAppLocale("uk")}
        if (count == 15) { setAppLocale("uk")}
        if (count == 16) { setAppLocale("uk")}
        if (count == 17) { setAppLocale("uk")}
        if (count == 18) { setAppLocale("uk")}
        if (count == 19) { setAppLocale("uk")}
        if (count == 20) { setAppLocale("uk")}
        if (count == 21) { setAppLocale("uk")}
        if (count == 22) { setAppLocale("uk")}
        if (count == 23) { setAppLocale("uk")}

        //--
    }
    override fun onBackPressed() {
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setTitle("Czy na pewno chcesz wyjść?")
        alertDialogBuilder.setMessage("Czy jesteś pewien, że chcesz opuścić aplikację?")
        alertDialogBuilder.setPositiveButton("Tak") { dialogInterface: DialogInterface, i: Int ->
            // Tutaj umieść kod wykonywany po kliknięciu przycisku "Tak"
            //super.onBackPressed()
            finishAffinity()
        }
        alertDialogBuilder.setNegativeButton("Nie") { dialogInterface: DialogInterface, i: Int ->
            // Tutaj umieść kod wykonywany po kliknięciu przycisku "Nie"
        }
        val alertDialog = alertDialogBuilder.create()
      alertDialog.show()
    }

    private fun setAppLocale(localeCode: String) {

        val locale = Locale(localeCode)
        Locale.setDefault(locale)
        val resources: Resources = baseContext.resources
        val configuration: Configuration = resources.configuration
        configuration.setLocale(locale)
        resources.updateConfiguration(configuration, resources.displayMetrics)
    }

    private fun makeCurrnetFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }

}