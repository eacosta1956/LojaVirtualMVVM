package com.eldon.lojavirtualmvvm.model

import com.google.gson.annotations.SerializedName

data class Produto(
    val id: Int,

    @SerializedName("title")
    val titulo: String,

    @SerializedName("description")
    val descricao: String,

    @SerializedName("category")
    val categoria: String,

    @SerializedName("price")
    val preco: Double,

    @SerializedName("thumbnail")
    val urlImagem: String
)