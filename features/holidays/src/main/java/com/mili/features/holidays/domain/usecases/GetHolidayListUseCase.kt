package com.mili.features.holidays.domain.usecases

import com.mili.features.holidays.domain.repo.IHolidaysRepository
import javax.inject.Inject

class GetHolidayListUseCase @Inject constructor(private val holidaysRepository: IHolidaysRepository) {

    fun getHolidayListForCountry(country: String) {

    }
}