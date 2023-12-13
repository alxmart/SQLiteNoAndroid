package com.luizafmartinez.sqlitenoandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.luizafmartinez.sqlitenoandroid.database.DatabaseHelper

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dbHelper = DatabaseHelper(this)


    }
}