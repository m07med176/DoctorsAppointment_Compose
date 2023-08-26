package com.biteam.mohamed.domain.usecase

import com.biteam.mohamed.data.dto.Product
import com.biteam.mohamed.domain.IRepository
import kotlinx.coroutines.flow.flow


class GetAllProductsUseCase(private val repository: IRepository) {
    private val movieList = mutableListOf<Product>()
    operator fun invoke() = flow {
        val response = repository.getAllProducts().products
        movieList.addAll(response)
        emit(movieList)

    }
}