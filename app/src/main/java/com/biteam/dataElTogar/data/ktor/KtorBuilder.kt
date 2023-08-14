package com.biteam.dataElTogar.data.ktor

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.HttpCallValidator
import io.ktor.client.plugins.HttpRequestRetry
import io.ktor.client.plugins.HttpRequestTimeoutException
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.client.request.header
import io.ktor.http.isSuccess
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object KtorBuilder {

    fun createHttpClient( enableNetworkLogs: Boolean = true) =
        HttpClient(OkHttp) {
            defaultRequest {
                header("Content-Type", "application/json")
                header("Accept", "application/json")
            }

            // exception handling
            install(HttpTimeout) {
                requestTimeoutMillis = 10000
                connectTimeoutMillis = 10000
                socketTimeoutMillis = 10000
            }

            install(HttpRequestRetry) {
                maxRetries = 3
                retryIf { _, response -> !response.status.isSuccess() }
                retryOnExceptionIf { _, cause -> cause is HttpRequestTimeoutException }
                delayMillis { 3000L } // retries in 3, 6, 9, etc. seconds
            }

            install(HttpCallValidator) {
                handleResponseExceptionWithRequest { cause, _ -> println("exception $cause") }
            }

            install(ContentNegotiation) { json(
                Json {
                    ignoreUnknownKeys = true
                    isLenient = true
                    encodeDefaults = true
                    prettyPrint = true
                    coerceInputValues = true
                }
            ) }
            if (enableNetworkLogs) {
                install(Logging) {
                    logger = Logger.SIMPLE
                    level = LogLevel.ALL
                }
            }
        }
}