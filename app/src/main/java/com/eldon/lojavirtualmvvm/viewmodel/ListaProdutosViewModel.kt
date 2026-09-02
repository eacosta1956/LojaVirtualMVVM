package com.eldon.lojavirtualmvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eldon.lojavirtualmvvm.model.ClienteRetrofit
import com.eldon.lojavirtualmvvm.model.Produto
import kotlinx.coroutines.launch

class ListaProdutosViewModel : ViewModel() {

    private val _produtos = MutableLiveData<List<Produto>>()
    val produtos: LiveData<List<Produto>> = _produtos

    private val _carregando = MutableLiveData(false)
    val carregando: LiveData<Boolean> = _carregando

    private val _mensagemErro = MutableLiveData<String?>()
    val mensagemErro: LiveData<String?> = _mensagemErro

    fun carregarProdutos() {
        viewModelScope.launch {
            _carregando.value = true
            _mensagemErro.value = null

            try {
                val resposta = ClienteRetrofit.servicoProdutos.buscarProdutos()
                _produtos.value = resposta.produtos
            } catch (erro: Exception) {
                _mensagemErro.value = "Não foi possível carregar os produtos."
            } finally {
                _carregando.value = false
            }
        }
    }
}