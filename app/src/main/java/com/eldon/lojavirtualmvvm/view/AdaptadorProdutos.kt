package com.eldon.lojavirtualmvvm.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eldon.lojavirtualmvvm.databinding.ItemProdutoBinding
import com.eldon.lojavirtualmvvm.model.Produto

class AdaptadorProdutos : RecyclerView.Adapter<AdaptadorProdutos.ProdutoViewHolder>() {

    private val produtos = mutableListOf<Produto>()

    fun atualizarLista(novosProdutos: List<Produto>) {
        produtos.clear()
        produtos.addAll(novosProdutos)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProdutoViewHolder {
        val binding = ItemProdutoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ProdutoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProdutoViewHolder, position: Int) {
        holder.vincular(produtos[position])
    }

    override fun getItemCount(): Int = produtos.size

    class ProdutoViewHolder(
        private val binding: ItemProdutoBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun vincular(produto: Produto) {
            binding.produto = produto
        }
    }
}