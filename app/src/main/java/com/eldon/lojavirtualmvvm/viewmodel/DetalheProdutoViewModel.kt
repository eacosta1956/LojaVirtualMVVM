package com.eldon.lojavirtualmvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eldon.lojavirtualmvvm.model.ClienteRetrofit
import com.eldon.lojavirtualmvvm.model.Produto
import kotlinx.coroutines.launch

class DetalheProdutoViewModel : ViewModel() {

    private val _produto = MutableLiveData<Produto>()
    val produto: LiveData<Produto> = _produto

    private val _carregando = MutableLiveData(false)
    val carregando: LiveData<Boolean> = _carregando

    private val _mensagemErro = MutableLiveData<String?>()
    val mensagemErro: LiveData<String?> = _mensagemErro

    fun carregarProduto(idProduto: Int) {
        viewModelScope.launch {
            _carregando.value = true
            _mensagemErro.value = null

            try {
                _produto.value =
                    ClienteRetrofit.servicoProdutos.buscarProdutoPorId(idProduto)
            } catch (erro: Exception) {
                _mensagemErro.value = "Não foi possível carregar os detalhes do produto."
            } finally {
                _carregando.value = false
            }
        }
    }
}