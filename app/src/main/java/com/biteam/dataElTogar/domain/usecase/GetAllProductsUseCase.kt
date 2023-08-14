package com.biteam.dataElTogar.domain.usecase

import com.biteam.dataElTogar.data.dto.Product
import com.biteam.dataElTogar.domain.IRepository
import kotlinx.coroutines.flow.flow


class GetAllProductsUseCase(private val repository: IRepository) {
    private val movieList = mutableListOf<Product>()
    operator fun invoke() = flow {
        val response = repository.getAllProducts().products
        movieList.addAll(response)
        emit(movieList)

    }
}