package com.biteam.dataElTogar.di

import com.biteam.dataElTogar.data.ktor.KtorBuilder.createHttpClient
import com.biteam.dataElTogar.data.ktor.KtorService
import com.biteam.dataElTogar.data.repository.Repository
import com.biteam.dataElTogar.domain.usecase.GetAllProductsUseCase

object DIModule {
    private val httpClient = createHttpClient()
    private val service = KtorService(httpClient)
    private val repository = Repository(service)
    val getAllProductUseCase = GetAllProductsUseCase(repository)
}