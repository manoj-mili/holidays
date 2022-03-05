package com.mili.features.countries.data

import com.mili.features.countries.data.local.CountryEntity
import com.mili.features.countries.data.remote.models.HolidayCountryResponse
import com.mili.features.countries.domain.CountryDomainModel

const val flagURLTemplate = "https://countryflagsapi.com/png/"
fun List<CountryEntity>.mapEntityToDomain(): List<CountryDomainModel> {
    val countries = mutableListOf<CountryDomainModel>()
    this.map {
        countries.add(
            it.mapEntityToDomain()
        )
    }
    return countries
}

fun HolidayCountryResponse.mapResponseToEntity(): List<CountryEntity> {
    val countries = mutableListOf<CountryEntity>()
    this.response.countries.map {
        countries.add(
            CountryEntity(
                name = it.countryName,
                totalHolidays = it.totalHolidays,
                flagURL = flagURLTemplate.plus(it.countryCode),
                countryCode = it.countryCode,
                id = it.uuid,
                isDefault = false
            )
        )
    }

    return countries
}

fun CountryEntity.mapEntityToDomain(): CountryDomainModel {
    return CountryDomainModel(id, name, flagURL, totalHolidays, isDefault,countryCode)
}