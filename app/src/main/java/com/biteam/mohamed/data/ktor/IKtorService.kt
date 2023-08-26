package com.biteam.mohamed.data.ktor

import com.biteam.mohamed.data.dto.Product
import com.biteam.mohamed.data.dto.ProductResponse

interface IKtorService {
    suspend fun getAllProducts(): ProductResponse

    suspend fun getSingleProduct(productId: Int): Product
}