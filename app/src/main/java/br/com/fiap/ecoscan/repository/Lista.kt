package br.com.fiap.ecoscan.repository

import br.com.fiap.ecoscan.database.dao.ProdutoDao
import br.com.fiap.ecoscan.model.Produtos

fun popularBancoDeDados(dao: ProdutoDao) {
    val produtosExemplo = listOf(
        Produtos(nome = "Garrafa de Vidro Reutilizável", categoria = "Sustentável Bom", descricao = "Feita de vidro reciclável, ajuda a reduzir o uso de plástico descartável."),
        Produtos(nome = "Canudo de Plástico", categoria = "Não Sustentável", descricao = "Produto de uso único que contribui para a poluição dos oceanos."),
        Produtos(nome = "Sacola de Algodão", categoria = "Sustentável Bom", descricao = "Alternativa reutilizável às sacolas plásticas."),
        Produtos(nome = "Copo de Isopor", categoria = "Sustentável Ruim", descricao = "Material não biodegradável e de difícil reciclagem."),
        Produtos(nome = "Escova de Dentes de Bambu", categoria = "Sustentável Bom", descricao = "Material biodegradável que reduz o impacto ambiental das escovas plásticas.")
    )
    produtosExemplo.forEach { dao.inserirProduto(it) }
}
