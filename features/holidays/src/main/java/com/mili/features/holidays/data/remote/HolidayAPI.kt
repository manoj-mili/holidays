package com.mili.features.holidays.data.remote

import com.mili.core.network.Resource
import com.mili.features.holidays.data.remote.models.HolidayResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface HolidayAPI {

    @GET("/api/v2/holidays")
    suspend fun getHolidays(
        @Query("country") countryCode: String,
        @Query("year") year: Int
    ): HolidayResponse

}