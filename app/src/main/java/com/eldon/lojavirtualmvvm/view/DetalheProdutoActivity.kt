package com.eldon.lojavirtualmvvm.view

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.eldon.lojavirtualmvvm.R
import com.eldon.lojavirtualmvvm.databinding.ActivityDetalheProdutoBinding
import com.eldon.lojavirtualmvvm.viewmodel.DetalheProdutoViewModel

class DetalheProdutoActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_ID_PRODUTO = "id_produto"
    }

    private lateinit var binding: ActivityDetalheProdutoBinding

    private val viewModel: DetalheProdutoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_detalhe_produto
        )

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        binding.botaoVoltar.setOnClickListener {
            finish()
        }

        observarViewModel()

        val idProduto = intent.getIntExtra(EXTRA_ID_PRODUTO, -1)

        if (idProduto != -1) {
            viewModel.carregarProduto(idProduto)
        } else {
            binding.textoErro.text = "Produto não informado."
            binding.textoErro.visibility = View.VISIBLE
        }
    }

    private fun observarViewModel() {
        viewModel.mensagemErro.observe(this) { mensagem ->
            binding.textoErro.visibility =
                if (mensagem.isNullOrBlank()) View.GONE else View.VISIBLE
        }
    }
}