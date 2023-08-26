package com.biteam.mohamed.data.ktor

import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.HttpRequestTimeoutException
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ServerResponseException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

val regex = "\\{([^{}]*)\\}".toRegex()

inline fun <reified T : Any> String.getUrl(vararg params: T): String {
    val paramMap = mutableMapOf<String, Any>()
    for ((index, param) in params.withIndex()) {
        paramMap["param$index"] = param
    }

    val paramNames = regex.findAll(this).map { it.groupValues[1] }.toList()

    val paramMapWithName = mutableMapOf<String, Any>()
    for (name in paramNames) {
        if (paramMap.containsKey("param${paramNames.indexOf(name)}")) {
            paramMapWithName[name] = paramMap["param${paramNames.indexOf(name)}"] ?: ""
        } else if (!name.contains("{") && !name.contains("}")) {
            paramMapWithName[name] = name
        }
    }

    return this.replaceParams(paramMapWithName.toParamMap<T>())
}

inline fun <reified T : Any> Map<String, Any>.toParamMap(): Map<String, String> {
    val paramMap = mutableMapOf<String, String>()
    for ((key, value) in this) {
        if (value is T) {
            paramMap[key] = value.toString()
        }
    }
    return paramMap
}

fun String.replaceParams(paramMap: Map<String, String>): String {
    val result = StringBuilder()
    var index = 0
    while (index < this.length) {
        val startIndex = this.indexOf('{', index)
        if (startIndex == -1) {
            result.append(this.substring(index))
            break
        }
        val endIndex = this.indexOf('}', startIndex)
        if (endIndex == -1) {
            result.append(this.substring(index))
            break
        }
        result.append(this.substring(index, startIndex))
        val key = this.substring(startIndex + 1, endIndex)
        val value = paramMap[key] ?: "{$key}"
        result.append(value)
        index = endIndex + 1
    }
    return result.toString()
}

sealed interface Result<out T> {
    data class Success<T>(val data: T) : Result<T>
    data class Error(val exception: CustomMessage) : Result<Nothing>
    object Loading : Result<Nothing>
    object Idle : Result<Nothing>
}

fun <T> Flow<T>.asResult(shouldEmit: Boolean = true): Flow<Result<T>> {
    return this.map<T, Result<T>> { Result.Success(it) }
        .onStart { emit(Result.Loading) }
        .catch {
            if (it is Exception) {
                if (shouldEmit) {
                    emit(Result.Error(it.getRealException()))
                }
            } else {
                emit(Result.Error(CustomMessage.ExceptionMessage("System not responding.")))
            }
        }
}

sealed class CustomMessage(val message: String = "") {

    object NetworkError : CustomMessage("Something wrong with network, please try again.")
    object RandomError : CustomMessage("Something went wrong, please try again.")
    object ResponseError :
        CustomMessage("We are fixing your problem, Thank you for your patience.")

    object NoInternet : CustomMessage("No Internet")
    object NotFound : CustomMessage("Not Found")
    data class ExceptionMessage(val error: String) : CustomMessage(message = error)
}

fun Exception.getRealException(): CustomMessage =
    when (this) {
        is HttpRequestTimeoutException -> {
            CustomMessage.NetworkError
        }
        is RedirectResponseException -> {
            CustomMessage.NetworkError
        }
        is ClientRequestException -> {
            CustomMessage.NetworkError
        }
        is ServerResponseException -> {
            CustomMessage.ResponseError
        }
        else -> {
            CustomMessage.RandomError
        }
    }