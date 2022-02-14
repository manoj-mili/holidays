package com.mili.features.holidays.data

import retrofit2.http.GET

interface HolidayAPI {

    @GET("")
    fun getHolidays()

    @GET("")
    fun getCountries()

    @GET("")
    fun getDays()


}