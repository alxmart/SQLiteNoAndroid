package com.luizafmartinez.sqlitenoandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.luizafmartinez.sqlitenoandroid.database.DatabaseHelper
import com.luizafmartinez.sqlitenoandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val bancoDados by lazy {
        DatabaseHelper( this )
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView( binding.root)

        with(binding) {

            btnSalvar.setOnClickListener{
                salvar()
            }

            btnListar.setOnClickListener{
                listar()
            }

        }

        try {
            bancoDados.writableDatabase.execSQL(
              "INSERT INTO produtos VALUES (null,'Notebook Acer', 'Descricao...');"
            )
            Log.i("info_db", "Sucesso ao inserir.")
        } catch (e: Exception) {
            Log.i("info_db", "Sucesso ao inserir.")
        }
    }

    private fun listar() {

        val sql = "SELECT * FROM produtos;"

        val cursor = bancoDados.readableDatabase.rawQuery( sql, null )

        //cursor.moveToFirst()
        while ( cursor.moveToNext()) {   // false ou true

            Log.i("info_db", "posicao: ${cursor.position}")

        }
        cursor.moveToNext()


    }

    private fun salvar() {

        val titulo = binding.editProduto.text.toString()

        val sql = "INSERT INTO produtos VALUES (null,'$titulo', 'Descricao...');"

        try {
            bancoDados.writableDatabase.execSQL( sql )
            Log.i("info_db", "Sucesso ao inserir.")
        } catch (e: Exception) {
            Log.i("info_db", "Sucesso ao inserir.")
        }
    }

}