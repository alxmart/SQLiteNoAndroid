package com.luizafmartinez.sqlitenoandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
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
        produtoDAO.remover(21)
    }

    private fun atualizar() {
        val titulo = binding.editProduto.text.toString()
        val produtoDAO = ProdutoDAO(this)
        val produto = Produto(
            21, titulo, "descricao"
        )
        produtoDAO.atualizar(produto)

        if (produtoDAO.atualizar(produto)) {
            Toast.makeText(
                this,
                "Sucesso ao atualizar produto",
                Toast.LENGTH_SHORT
            ).show()
            binding.editProduto.setText("")
        } else {
            Toast.makeText(
                this,
                "Erro ao atualizar produto",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

        private fun listar() {

            val produtoDAO = ProdutoDAO(this)
            val listaProdutos = produtoDAO.listar()

            var texto = ""
            if (listaProdutos.isNotEmpty()) {
                listaProdutos.forEach { produto ->
                    texto += "${produto.idProduto} - ${produto.titulo} \n"
                    Log.i("info_db", "${produto.idProduto} - ${produto.titulo}")
                }
                binding.textResultado.text = texto
            } else {
                binding.textResultado.text = "Nenhum item cadastrado."
            }
        }

        private fun salvar() {

            val titulo = binding.editProduto.text.toString()
            val produtoDAO = ProdutoDAO(this)
            val produto = Produto(
                -1, titulo, "descricao"
            )
            if (produtoDAO.salvar(produto)) {
                Toast.makeText(
                    this,
                    "Sucesso ao cadastrar produto",
                    Toast.LENGTH_SHORT
                ).show()
                binding.editProduto.setText("")
            } else {
                Toast.makeText(
                    this,
                    "Erro ao cadastrar produto",
                    Toast.LENGTH_SHORT
                ).show()

            }
        }
    }
