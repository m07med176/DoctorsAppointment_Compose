package com.biteam.dataElTogar.data.ktor

import com.biteam.dataElTogar.data.dto.Product
import com.biteam.dataElTogar.data.dto.ProductResponse

interface IKtorService {
    suspend fun getAllProducts(): ProductResponse

    suspend fun getSingleProduct(productId: Int): Product
}