package com.biteam.mohamed.domain

import com.biteam.mohamed.data.dto.Product
import com.biteam.mohamed.data.dto.ProductResponse

interface IRepository {
    suspend fun getAllProducts(): ProductResponse

    suspend fun getSingleProduct(productId: Int): Product
}