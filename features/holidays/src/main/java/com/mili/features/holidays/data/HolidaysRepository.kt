package com.mili.features.holidays.data

import com.mili.features.holidays.di.HolidayFeatureScope
import com.mili.features.holidays.domain.models.HolidayCountryDomainModel
import com.mili.features.holidays.domain.models.HolidayDaysDomainModel
import com.mili.features.holidays.domain.models.HolidayDomainModel
import com.mili.features.holidays.domain.repo.IHolidaysRepository
import javax.inject.Inject

@HolidayFeatureScope
class HolidaysRepository @Inject constructor(
    private val holidayAPI: HolidayAPI,
    private val mapper: HolidayMapper
) : IHolidaysRepository {
    override suspend fun getHolidaysForCountry(country: String): List<HolidayDomainModel> {
        TODO("Not yet implemented")
    }

    override suspend fun getCountryList(): List<HolidayCountryDomainModel> {
        TODO("Not yet implemented")
    }

    override suspend fun getDayList(): List<HolidayDaysDomainModel> {
        TODO("Not yet implemented")
    }
}