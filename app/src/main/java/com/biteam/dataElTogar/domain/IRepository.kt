package com.biteam.dataElTogar.domain

import com.biteam.dataElTogar.data.dto.Product
import com.biteam.dataElTogar.data.dto.ProductResponse

interface IRepository {
    suspend fun getAllProducts(): ProductResponse

    suspend fun getSingleProduct(productId: Int): Product
}