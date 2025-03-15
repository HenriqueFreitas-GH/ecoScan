package br.com.fiap.ecoscan.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import br.com.fiap.ecoscan.model.Produtos

@Dao
interface ProdutoDao {

    @Update
    fun atualizar(produto: Produtos): Int

    @Delete
    fun excluir(produto: Produtos): Int

    @Query("SELECT * FROM produtos WHERE id = :id")
    fun buscarProdutoPeloId(id: Int): Produtos


    @Query("SELECT * FROM produtos")
    fun getTodosProdutos(): List<Produtos>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun inserirProduto(produto: Produtos)
}
