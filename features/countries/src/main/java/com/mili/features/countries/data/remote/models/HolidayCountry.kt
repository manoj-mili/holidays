package com.mili.features.countries.data.remote.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HolidayCountryResponse(
    @Json(name = "response")
     val response: HolidayCountriesResponse
)

@JsonClass(generateAdapter = true)
data class HolidayCountriesResponse(
    @Json(name = "countries")
     val countries: List<HolidayCountry> = listOf()
)

@JsonClass(generateAdapter = true)
data class HolidayCountry(
    @Json(name = "uuid")
    val uuid: String,
    @Json(name = "iso-3166")
     val countryCode: String,
    @Json(name = "country_name")
     val countryName: String,
    @Json(name = "total_holidays")
     val totalHolidays: Int
)