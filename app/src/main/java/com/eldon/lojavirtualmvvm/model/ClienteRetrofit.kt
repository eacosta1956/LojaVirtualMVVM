package com.eldon.lojavirtualmvvm.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ClienteRetrofit {

    private const val URL_BASE = "https://dummyjson.com/"

    val servicoProdutos: ServicoProdutosApi by lazy {
        Retrofit.Builder()
            .baseUrl(URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ServicoProdutosApi::class.java)
    }
}