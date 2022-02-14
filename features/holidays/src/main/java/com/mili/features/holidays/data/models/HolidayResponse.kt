package com.mili.features.holidays.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class Response(

    @Json(name = "holidays") var holidays: ArrayList<Holidays> = arrayListOf()

)

@JsonClass(generateAdapter = true)
data class HolidayResponse(

    @Json(name = "meta") var meta: Meta? = Meta(),
    @Json(name = "response") var response: Response? = Response()

)
@JsonClass(generateAdapter = true)
data class Meta(

    @Json(name = "code") var code: Int? = null

)
@JsonClass(generateAdapter = true)
data class Holidays(

    @Json(name = "name") var name: String? = null,
    @Json(name = "description") var description: String? = null,
    @Json(name = "date") var date: Date? = Date(),
    @Json(name = "type") var type: ArrayList<String> = arrayListOf()

)
@JsonClass(generateAdapter = true)
data class Date(

    @Json(name = "iso") var iso: String? = null,
    @Json(name = "datetime") var datetime: Datetime? = Datetime()

)
@JsonClass(generateAdapter = true)
data class Datetime(

    @Json(name = "year") var year: Int? = null,
    @Json(name = "month") var month: Int? = null,
    @Json(name = "day") var day: Int? = null

)