package com.mili.features.holidays.domain.repo

import com.mili.core.network.Resource
import com.mili.features.holidays.domain.models.HolidayDomainModel
import kotlinx.coroutines.flow.Flow
import org.json.JSONObject

interface IHolidaysRepository {

    suspend fun getHolidaysForCountry(countryCode:String): Flow<Resource<List<HolidayDomainModel>>>

}