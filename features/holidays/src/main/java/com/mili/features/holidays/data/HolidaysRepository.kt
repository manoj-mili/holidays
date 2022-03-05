package com.mili.features.holidays.data

import com.mili.core.utils.networkBoundResource
import com.mili.features.holidays.data.local.HolidayDao
import com.mili.features.holidays.data.remote.HolidayAPI
import com.mili.features.holidays.domain.repo.IHolidaysRepository
import com.mili.holidays.core.DispatcherProvider
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class HolidaysRepository @Inject constructor(
    private val holidayAPI: HolidayAPI,
    private val holidayDao: HolidayDao,
    private val dispatcherProvider: DispatcherProvider,
) : IHolidaysRepository {
    override suspend fun getHolidaysForCountry(countryCode: String) = networkBoundResource(
        query = {
            holidayDao.getHolidayForCountry(countryCode).map {
                it.mapEntityToDomain()
            }
        },
        shouldFetch = {
            it.isEmpty()
        },
        fetch = {
            holidayAPI.getHolidays(countryCode, 2022)
        },
        saveFetchResult = {
            holidayDao.saveHolidays(it.mapResponseToEntity(countryCode))
        },
        clearData = {}
    )
}