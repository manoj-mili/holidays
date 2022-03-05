package com.mili.features.countries.domain

import com.mili.core.network.Resource
import kotlinx.coroutines.flow.Flow

interface ICountryRepository {

    suspend fun getCountries(): Flow<Resource<List<CountryDomainModel>>>

    suspend fun getDefaultSelectedCountry(): CountryDomainModel?

    suspend fun updateDefaultCountry(countryId: String)


}