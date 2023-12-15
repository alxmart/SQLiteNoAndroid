package com.luizafmartinez.sqlitenoandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.luizafmartinez.sqlitenoandroid.database.DatabaseHelper

class MainActivity : AppCompatActivity() {

    private val bancoDados by lazy {
        DatabaseHelper( this )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {
            bancoDados.writableDatabase.execSQL(
              "INSERT INTO produtos VALUES (null,'Notebook Acer', 'Descricao...');"
            )
            Log.i("info_db", "Sucesso ao inserir.")
        } catch (e: Exception) {
            Log.i("info_db", "Sucesso ao inserir.")
        }

    }
}