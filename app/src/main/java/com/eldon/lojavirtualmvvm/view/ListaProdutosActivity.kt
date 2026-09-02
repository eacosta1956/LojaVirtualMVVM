package com.eldon.lojavirtualmvvm.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.eldon.lojavirtualmvvm.R
import com.eldon.lojavirtualmvvm.databinding.ActivityListaProdutosBinding
import com.eldon.lojavirtualmvvm.viewmodel.ListaProdutosViewModel

class ListaProdutosActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListaProdutosBinding

    private val viewModel: ListaProdutosViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(
            this,
            R.layout.activity_lista_produtos
        )

        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }
}