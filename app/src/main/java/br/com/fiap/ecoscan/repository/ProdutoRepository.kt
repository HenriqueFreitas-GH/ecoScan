package br.com.fiap.ecoscan.repository

import android.content.Context
import br.com.fiap.ecoscan.database.dao.Produtodb
import br.com.fiap.ecoscan.model.Produtos

class ProdutoRepository (context: Context){
    var db = Produtodb.getDatabase(context).produtoDao()

    fun atualizar(produto: Produtos): Int{
        return db.atualizar(produto = produto)
    }

    fun excluir(produto: Produtos): Int{
        return db.excluir(produto = produto)
    }

    fun buscarProdutoPeloId(id: Int): Produtos {
        return db.buscarProdutoPeloId(id = id)
    }

    fun getTodosProdutos(): List<Produtos>{
        return db.getTodosProdutos()
    }
    fun inserirProduto(produto: Produtos){}
}