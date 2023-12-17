package com.luizafmartinez.sqlitenoandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.luizafmartinez.sqlitenoandroid.database.DatabaseHelper
import com.luizafmartinez.sqlitenoandroid.database.ProdutoDAO
import com.luizafmartinez.sqlitenoandroid.databinding.ActivityMainBinding
import com.luizafmartinez.sqlitenoandroid.model.Produto

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

            btnAtualizar.setOnClickListener {
                atualizar()
            }

            btnRemover.setOnClickListener {
                remover()
            }
        }
    }

    private fun remover() {
        val produtoDAO = ProdutoDAO(this)
        produtoDAO.remover(18)
    }

    private fun atualizar() {
        val titulo = binding.editProduto.text.toString()
        val produtoDAO = ProdutoDAO(this)
        val produto = Produto(
            18, titulo, "descricao"
        )
        produtoDAO.atualizar( produto )
    }

    private fun listar() {
        val produtoDAO = ProdutoDAO(this)
        val listaProdutos = produtoDAO.listar()
        if ( listaProdutos.isNotEmpty() ) {
            listaProdutos.forEach { produto ->
                Log.i("info_db", "${produto.idProduto} - ${produto.titulo}")
            }
        }
    }

      private fun salvar() {
        val titulo = binding.editProduto.text.toString()
        val produtoDAO = ProdutoDAO(this)
        val produto = Produto(
            -1, titulo, "descricao"
        )
        produtoDAO.salvar( produto )
    }

}