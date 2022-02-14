package com.mili.features.holidays.data

import com.mili.core.mapper.IDataMapper
import com.mili.features.holidays.data.models.HolidayResponse
import com.mili.features.holidays.domain.models.HolidayDomainModel
import javax.inject.Inject

class HolidayMapper @Inject constructor(): IDataMapper<HolidayResponse, List<HolidayDomainModel>> {
    override fun mapEntityToDomain(entity: HolidayResponse): List<HolidayDomainModel> {
        TODO("Not yet implemented")
    }

    override fun mapDomainToEntity(domain: List<HolidayDomainModel>): HolidayResponse {
        TODO("Not yet implemented")
    }
}