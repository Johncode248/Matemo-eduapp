package com.lions.anew

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

// Nazwa tabeli i kolumny
const val TABLE_NAME = "zadania"
const val COLUMN_NAME_COUNT = "count"
const val COLUMN_NAME_DATA = "data"
const val COLUMN_NAME_A1 = "a1"
const val COLUMN_NAME_A2= "a2"
const val COLUMN_NAME_A3= "a3"
const val COLUMN_NAME_A4 = "a4"
const val COLUMN_NAME_A5 = "a5"
const val COLUMN_NAME_A6 = "a6"
const val COLUMN_NAME_A7 = "a7"
const val COLUMN_NAME_A8 = "a8"
const val COLUMN_NAME_A9 = "a9"
const val COLUMN_NAME_A10 = "a10"
const val COLUMN_NAME_A11 = "a11"
const val COLUMN_NAME_A12 = "a12"
const val COLUMN_NAME_A13 = "a13"
const val COLUMN_NAME_A14 = "a14"
const val COLUMN_NAME_A15 = "a15"
const val COLUMN_NAME_A16 = "a16"
const val COLUMN_NAME_A17 = "a17"
const val COLUMN_NAME_A18 = "a18"
const val COLUMN_NAME_A19 = "a19"
const val COLUMN_NAME_A20 = "a20"
const val COLUMN_NAME_A21 = "a21"
const val COLUMN_NAME_A22 = "a22"
const val COLUMN_NAME_A23 = "a23"
const val COLUMN_NAME_A24 = "a24"
const val COLUMN_NAME_A25 = "a25"
const val COLUMN_NAME_A26 = "a26"
const val COLUMN_NAME_A27 = "a27"
const val COLUMN_NAME_A28 = "a28"
const val COLUMN_NAME_A29 = "a29"
const val COLUMN_NAME_A30 = "a30"

const val Language = "jezyk"

class MyDatabaseHelper(context : Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    // Nazwa i wersja bazy danych
    companion object {
        const val DATABASE_NAME = "MyDatabase.db"
        const val DATABASE_VERSION = 22
    }

    // Tworzenie tabeli
    override fun onCreate(db: SQLiteDatabase) {
        val sql = "CREATE TABLE $TABLE_NAME (" +
                "$COLUMN_NAME_COUNT INTEGER," +
                "$COLUMN_NAME_DATA INTEGER," +
                "$COLUMN_NAME_A1 INTEGER," +
                "$COLUMN_NAME_A2 INTEGER," +
                "$COLUMN_NAME_A3 INTEGER," +
                "$COLUMN_NAME_A4 INTEGER," +
                "$COLUMN_NAME_A5 INTEGER," +
                "$COLUMN_NAME_A6 INTEGER," +
                "$COLUMN_NAME_A7 INTEGER," +
                "$COLUMN_NAME_A8 INTEGER," +
                "$COLUMN_NAME_A9 INTEGER," +
                "$COLUMN_NAME_A10 INTEGER," +
                "$COLUMN_NAME_A11 INTEGER," +
                "$COLUMN_NAME_A12 INTEGER," +
                "$COLUMN_NAME_A13 INTEGER," +
                "$COLUMN_NAME_A14 INTEGER," +
                "$COLUMN_NAME_A15 INTEGER," +
                "$COLUMN_NAME_A16 INTEGER," +
                "$COLUMN_NAME_A17 INTEGER," +
                "$COLUMN_NAME_A18 INTEGER," +
                "$COLUMN_NAME_A19 INTEGER," +
                "$COLUMN_NAME_A20 INTEGER," +
                "$COLUMN_NAME_A21 INTEGER," +
                "$COLUMN_NAME_A22 INTEGER," +
                "$COLUMN_NAME_A23 INTEGER," +
                "$COLUMN_NAME_A24 INTEGER," +
                "$COLUMN_NAME_A25 INTEGER," +
                "$COLUMN_NAME_A26 INTEGER," +
                "$COLUMN_NAME_A27 INTEGER," +
                "$COLUMN_NAME_A28 INTEGER," +
                "$COLUMN_NAME_A29 INTEGER," +
                "$COLUMN_NAME_A30 INTEGER," +
                "$Language INTEGER" +
                ")"
        db.execSQL(sql)

        // Wstawienie początkowej wartości do tabeli
        val values = ContentValues().apply {
            put(COLUMN_NAME_COUNT, 200)
            put(COLUMN_NAME_DATA, 0)
            put(COLUMN_NAME_A1, 0)
            put(COLUMN_NAME_A2, 0)
            put(COLUMN_NAME_A3, 0)


            put(Language, 0)
        }
        db.insert(TABLE_NAME, null, values)

    }







    // Aktualizacja tabeli
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Usuń istniejącą tabelę
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")

        // Stwórz nową tabelę
        onCreate(db)
    }
}