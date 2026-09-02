package com.eldon.lojavirtualmvvm.model

import retrofit2.http.GET
import retrofit2.http.Path

interface ServicoProdutosApi {

    @GET("products")
    suspend fun buscarProdutos(): RespostaProdutos

    @GET("products/{id}")
    suspend fun buscarProdutoPorId(
        @Path("id") idProduto: Int
    ): Produto
}