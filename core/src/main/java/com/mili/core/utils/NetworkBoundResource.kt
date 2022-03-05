package com.mili.core.utils

import com.mili.core.network.Resource
import kotlinx.coroutines.flow.*

inline fun <ResultType, RequestType> networkBoundResource(
    crossinline query: () -> Flow<ResultType>,
    crossinline fetch: suspend () -> RequestType,
    crossinline saveFetchResult: suspend (RequestType) -> Unit,
    crossinline clearData: suspend () -> Unit,
    crossinline onFetchFailed: (Throwable) -> Unit = { Unit },
    crossinline shouldFetch: (ResultType) -> Boolean = { true },
    crossinline shouldClear: (RequestType, ResultType) -> Boolean = { requestType: RequestType, resultType: ResultType -> false }
) = flow<Resource<ResultType>> {

    emit(Resource.Loading(null))

    val dbData = query().first()
    val flow = if (shouldFetch(dbData)) {
        emit(Resource.Loading(dbData))
        try {
            val fetchData = fetch()
            if (shouldClear(fetchData, dbData)) {
                clearData()
            }
            saveFetchResult(fetchData)
            query().map { Resource.Success(it) }

        } catch (throwable: Throwable) {
            throwable.printStackTrace()
            onFetchFailed(throwable)
            query().map { Resource.Error(throwable.message, it) }
        }

    } else {
        query().map { Resource.Success(it) }
    }

    emitAll(flow)
}