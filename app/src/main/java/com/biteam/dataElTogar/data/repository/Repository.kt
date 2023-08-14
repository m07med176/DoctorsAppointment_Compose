package com.biteam.dataElTogar.data.repository

import com.biteam.dataElTogar.data.dto.Product
import com.biteam.dataElTogar.data.dto.ProductResponse
import com.biteam.dataElTogar.data.ktor.IKtorService
import com.biteam.dataElTogar.domain.IRepository

class Repository(val api:IKtorService):IRepository {
    override suspend fun getAllProducts(): ProductResponse = api.getAllProducts()
    override suspend fun getSingleProduct(productId: Int): Product = api.getSingleProduct(productId)
}