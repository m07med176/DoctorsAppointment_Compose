package com.biteam.mohamed.data.repository

import com.biteam.mohamed.data.dto.Product
import com.biteam.mohamed.data.dto.ProductResponse
import com.biteam.mohamed.data.ktor.IKtorService
import com.biteam.mohamed.domain.IRepository

class Repository(val api:IKtorService):IRepository {
    override suspend fun getAllProducts(): ProductResponse = api.getAllProducts()
    override suspend fun getSingleProduct(productId: Int): Product = api.getSingleProduct(productId)
}