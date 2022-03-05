package com.mili.features.countries.data.remote

import com.mili.features.countries.data.remote.models.HolidayCountryResponse
import retrofit2.http.GET

interface CountryAPI {

    @GET("/api/v2/countries")
    suspend fun getCountries(): HolidayCountryResponse
}