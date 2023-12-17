package com.luizafmartinez.sqlitenoandroid.database

import com.luizafmartinez.sqlitenoandroid.model.Produto

interface IProdutoDAO {

    fun salvar(produto: Produto): Boolean
    fun atualizar(produto: Produto): Boolean
    fun remover(idProduto: Int): Boolean
    fun listar(): List<Produto>
}

