package com.mili.features.holidays.data.remote.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class Response(
    @Json(name = "holidays") val holidays: List<Holidays> = listOf()
)

@JsonClass(generateAdapter = true)
data class HolidayResponse(
    @Json(name = "response") val response: Response? = Response()
)

@JsonClass(generateAdapter = true)
data class Holidays(
    @Json(name = "name") val name: String,
    @Json(name = "description") val description: String,
    @Json(name = "date") val date: Date?,
    @Json(name = "type") val type: List<String> = listOf()
)

@JsonClass(generateAdapter = true)
data class Date(
    @Json(name = "iso") val iso: String,
    @Json(name = "datetime") val datetime: Datetime = Datetime()

)

@JsonClass(generateAdapter = true)
data class Datetime(
    @Json(name = "year") val year: Int? = null,
    @Json(name = "month") val month: Int? = null,
    @Json(name = "day") val day: Int? = null

)