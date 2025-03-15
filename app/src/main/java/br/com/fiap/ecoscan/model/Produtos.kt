package br.com.fiap.ecoscan.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "produtos")
data class Produtos(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nome: String,
    val categoria: String,
    val descricao: String
)
