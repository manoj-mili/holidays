package com.mili.features.countries.domain

import com.mili.core.network.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchCountriesUseCase @Inject constructor(private val repository: ICountryRepository) {

    suspend fun getCountries(): Flow<Resource<List<CountryDomainModel>>> {
        return repository.getCountries()
    }
}