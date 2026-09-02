package com.eldon.lojavirtualmvvm.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.eldon.lojavirtualmvvm.R
import com.eldon.lojavirtualmvvm.databinding.ActivityTelaInicialBinding
import android.content.Intent

class TelaInicialActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTelaInicialBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_tela_inicial
        )

        binding.lifecycleOwner = this

        binding.botaoProdutos.setOnClickListener {
            val intencao = Intent(this, ListaProdutosActivity::class.java)
            startActivity(intencao)
        }
    }
}