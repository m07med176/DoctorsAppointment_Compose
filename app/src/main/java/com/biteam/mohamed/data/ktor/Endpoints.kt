package com.biteam.mohamed.data.ktor

object Endpoints {
    private const val BASE_URL = "https://dummyjson.com"
    const val GET_ALL_PRODUCT = "$BASE_URL/products"
    const val GET_SINGLE_PRODUCT = "$BASE_URL/products/{productId}"
}