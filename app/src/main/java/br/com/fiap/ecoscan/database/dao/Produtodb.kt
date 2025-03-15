package br.com.fiap.ecoscan.database.dao

import android.content.Context
import androidx.room.*
import br.com.fiap.ecoscan.model.Produtos


// Banco de Dados Room
@Database(entities = [Produtos::class], version = 1)
abstract class Produtodb : RoomDatabase() {
    abstract fun produtoDao(): ProdutoDao

    companion object {
        @Volatile
        private var INSTANCE: Produtodb? = null

        fun getDatabase(context: Context): Produtodb {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    Produtodb::class.java,
                    "ecoscan_db"
                ).allowMainThreadQueries().build()
                INSTANCE = instance
                instance
            }
        }
    }
}
