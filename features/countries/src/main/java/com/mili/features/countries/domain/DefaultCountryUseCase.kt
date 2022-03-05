package com.mili.features.countries.domain

import javax.inject.Inject

class DefaultCountryUseCase @Inject constructor(private val repository: ICountryRepository) {

    suspend fun getDefaultCountry(): CountryDomainModel? {
        return repository.getDefaultSelectedCountry()
    }

    suspend fun updateDefaultCountry(countryId: String) {
        repository.updateDefaultCountry(countryId)
    }

}