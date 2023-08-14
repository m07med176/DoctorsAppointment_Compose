package com.biteam.dataElTogar.presentation.features.authentication

import com.biteam.dataElTogar.data.dto.Product
import kotlinx.coroutines.flow.asStateFlow

import androidx.lifecycle.viewModelScope
import com.biteam.dataElTogar.data.ktor.CustomMessage
import com.biteam.dataElTogar.data.ktor.asResult
import com.biteam.dataElTogar.di.DIModule
import com.biteam.dataElTogar.domain.usecase.GetAllProductsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import com.biteam.dataElTogar.data.ktor.Result
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.update

class AuthenticationViewModel(
    private val getAllProductsUseCase: GetAllProductsUseCase = DIModule.getAllProductUseCase
): ViewModel(){
    private val _products = MutableStateFlow<ProductsState<List<Product>>>(ProductsState.Idle())
    val products = _products.asStateFlow()
    init {
        setIntent(ProductIntent.GetAllProduct)
    }

    fun setIntent(intent: ProductIntent){
        when(intent){
            is ProductIntent.GetAllProduct -> fetchAllProducts()
        }
    }

    private fun fetchAllProducts() {
        viewModelScope.launch {
            getAllProductsUseCase().asResult().collectLatest {result->
                when(result){
                    is Result.Error -> _products.update { ProductsState.Error(result.exception) }
                    is Result.Idle -> _products.update { ProductsState.Idle() }
                    is Result.Loading -> _products.update { ProductsState.Loading() }
                    is Result.Success -> _products.update { ProductsState.Success(result.data) }
                }
            }
        }
    }

    sealed interface ProductsState<Entity> {

        class Loading<Entity>: ProductsState<Entity>

        class Idle<Entity> : ProductsState<Entity>

        data class Success<Entity>(val data: Entity) : ProductsState<Entity>

        data class Error<Entity>(val error: CustomMessage) : ProductsState<Entity>
    }

    sealed class ProductIntent{
        object GetAllProduct:ProductIntent()
  }
}