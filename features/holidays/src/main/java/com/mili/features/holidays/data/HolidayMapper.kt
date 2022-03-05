package com.mili.features.holidays.data

import com.mili.core.utils.getDayFromDate
import com.mili.core.utils.getFormattedDate
import com.mili.core.utils.isLongWeekend
import com.mili.core.utils.isNationalHoliday
import com.mili.features.holidays.data.local.HolidayEntity
import com.mili.features.holidays.data.remote.models.HolidayResponse
import com.mili.features.holidays.domain.models.HolidayDomainModel


fun HolidayResponse.mapResponseToEntity(countryCode: String): List<HolidayEntity> {
    val holidays = mutableListOf<HolidayEntity>()
    this.response?.holidays?.map {
        holidays.add(
            HolidayEntity(
                name = it.name,
                country = countryCode,
                date = it.date?.iso ?: "",
                description = it.description,
                types = it.type.joinToString(separator = ",")
            )
        )
    }
    return holidays
}


fun List<HolidayEntity>.mapEntityToDomain(): List<HolidayDomainModel> {
    val holidays = mutableListOf<HolidayDomainModel>()
    this.map {
        val day = getDayFromDate(it.date)
        holidays.add(
            HolidayDomainModel(
                it.id,
                it.name,
                getFormattedDate(it.date),
                day,
                isNationalHoliday(it.types),
                isLongWeekend(day),
                it.country,
                it.description,
                it.types.split(",")
            )
        )
    }
    return holidays
}