package com.eldon.lojavirtualmvvm.model

import retrofit2.http.GET

interface ServicoProdutosApi {

    @GET("products")
    suspend fun buscarProdutos(): RespostaProdutos
}