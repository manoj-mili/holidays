package com.mili.features.holidays.domain.usecases

import com.mili.core.network.Resource
import com.mili.features.holidays.domain.models.HolidayDomainModel
import com.mili.features.holidays.domain.repo.IHolidaysRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetHolidayListUseCase @Inject constructor(
    private val repository: IHolidaysRepository) {

    suspend fun getHolidayListForCountry(countryCode: String): Flow<Resource<List<HolidayDomainModel>>> {
        return repository.getHolidaysForCountry(countryCode)
    }
}