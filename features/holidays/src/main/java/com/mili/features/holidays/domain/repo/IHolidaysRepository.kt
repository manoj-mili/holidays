package com.mili.features.holidays.domain.repo

import com.mili.features.holidays.domain.models.HolidayCountryDomainModel
import com.mili.features.holidays.domain.models.HolidayDaysDomainModel
import com.mili.features.holidays.domain.models.HolidayDomainModel

interface IHolidaysRepository {

    suspend fun getHolidaysForCountry(country:String):List<HolidayDomainModel>

    suspend fun getCountryList():List<HolidayCountryDomainModel>

    suspend fun getDayList():List<HolidayDaysDomainModel>
}