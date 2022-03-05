package com.mili.core.utils

import com.mili.core.network.Resource
import retrofit2.HttpException
import retrofit2.Response
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

suspend fun <T : Any> safeApiCall(call: suspend () -> Response<T>): Resource<T> {
    try {
        val response = call.invoke()
        if (response.isSuccessful) {
            if (response.body() != null) {
                return Resource.Success(response.body())
            }
        }
        return Resource.Error(response.message())
    } catch (e: Exception) {
        return when (e) {
            is ConnectException -> {
                Resource.Error(CONNECT_EXCEPTION)
            }
            is UnknownHostException -> {
                Resource.Error(UNKNOWN_HOST_EXCEPTION)
            }
            is SocketTimeoutException -> {
                Resource.Error(SOCKET_TIME_OUT_EXCEPTION)
            }
            is HttpException -> {
                Resource.Error(UNKNOWN_NETWORK_EXCEPTION)
            }
            else -> {
                Resource.Error(UNKNOWN_NETWORK_EXCEPTION)
            }
        }
    }
}