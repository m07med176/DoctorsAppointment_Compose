package com.biteam.mohamed.di

import com.biteam.mohamed.data.ktor.KtorBuilder.createHttpClient
import com.biteam.mohamed.data.ktor.KtorService
import com.biteam.mohamed.data.repository.Repository
import com.biteam.mohamed.domain.usecase.GetAllProductsUseCase

object DIModule {
    private val httpClient = createHttpClient()
    private val service = KtorService(httpClient)
    private val repository = Repository(service)
    val getAllProductUseCase = GetAllProductsUseCase(repository)
}