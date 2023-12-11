package com.luizafmartinez.sqlitenoandroid.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context): SQLiteOpenHelper(

    // 1) Contexto (context-> to use for locating paths to the database.)
    // 2) Nome do B.D.      3) CursorFactory      4) Versão do B.D.

    context, "loja.db", null, 1
) {
    override fun onCreate(db: SQLiteDatabase?) {


    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {



    }
}