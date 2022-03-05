package com.mili.features.countries.data

import com.mili.core.utils.networkBoundResource
import com.mili.features.countries.data.local.CountryDao
import com.mili.features.countries.data.local.CountryEntity
import com.mili.features.countries.data.remote.CountryAPI
import com.mili.features.countries.domain.CountryDomainModel
import com.mili.features.countries.domain.ICountryRepository
import com.mili.holidays.core.DispatcherProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CountryRepository @Inject constructor(
    private val dao: CountryDao,
    private val countryAPI: CountryAPI,
    private val dispatcherProvider: DispatcherProvider,
) : ICountryRepository {
    override suspend fun getCountries() = networkBoundResource(
        query = {
            dao.getCountries().map {
                it.mapEntityToDomain()
            }
        },
        shouldFetch = { it.isEmpty() },
        fetch = { countryAPI.getCountries() },
        saveFetchResult = {
            dao.insertCountries(it.mapResponseToEntity())
        },
        clearData = {}
    )


    override suspend fun getDefaultSelectedCountry(): CountryDomainModel? {
        return withContext(dispatcherProvider.io()) {
            dao.getDefaultCountry()
                ?.mapEntityToDomain()
        }
    }


    override suspend fun updateDefaultCountry(countryId: String) {
        withContext(dispatcherProvider.io()) {
            dao.updateDefaultCountry(countryId)
        }
    }
}