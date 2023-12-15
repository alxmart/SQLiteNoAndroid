package com.luizafmartinez.sqlitenoandroid.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DatabaseHelper(context: Context): SQLiteOpenHelper(

    context, "loja.db", null, 3

    // 1) Contexto (context-> to use for locating paths to the database.)
    // 2) Nome do B.D.      3) CursorFactory      4) Versão do B.D.
) {
    override fun onCreate(db: SQLiteDatabase?) {

        Log.i("info_db", "Executou onCreate.")

        val sql = "CREATE TABLE IF NOT EXISTS produtos (" +
                "id_produto integer not null primary KEY AUTOINCREMENT," +
                "titulo varchar(100)," +
                "descricao text" +
                ");"
        try {
            db?.execSQL( sql )
            Log.i("info_db", "Sucesso ao criar a tabela.")
        } catch (e: Exception) {
            // e.message  // Exibir na tela o erro
            e.printStackTrace()
            Log.i("info_db", " ERRO ao criar a tabela.")
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        Log.i("info_db", " Executou onUpgrade.")
    }
}