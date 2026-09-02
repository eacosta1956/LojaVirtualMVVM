package com.eldon.lojavirtualmvvm.view

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.eldon.lojavirtualmvvm.R
import com.eldon.lojavirtualmvvm.databinding.ActivityListaProdutosBinding
import com.eldon.lojavirtualmvvm.viewmodel.ListaProdutosViewModel

class ListaProdutosActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListaProdutosBinding

    private val viewModel: ListaProdutosViewModel by viewModels()

    private val adaptadorProdutos = AdaptadorProdutos()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_lista_produtos
        )

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        binding.botaoVoltar.setOnClickListener {
            finish()
        }

        configurarRecyclerView()
        observarViewModel()

        viewModel.carregarProdutos()
    }

    private fun configurarRecyclerView() {
        binding.recyclerProdutos.layoutManager = LinearLayoutManager(this)
        binding.recyclerProdutos.adapter = adaptadorProdutos
    }

    private fun observarViewModel() {
        viewModel.produtos.observe(this) { produtos ->
            adaptadorProdutos.atualizarLista(produtos)
        }

        viewModel.mensagemErro.observe(this) { mensagem ->
            binding.textoErro.visibility =
                if (mensagem.isNullOrBlank()) View.GONE else View.VISIBLE
        }
    }
}