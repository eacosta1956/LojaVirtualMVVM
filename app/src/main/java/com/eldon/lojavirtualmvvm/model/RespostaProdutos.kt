package com.eldon.lojavirtualmvvm.model

import com.google.gson.annotations.SerializedName

data class RespostaProdutos(
    @SerializedName("products")
    val produtos: List<Produto>
)