package com.mili.features.holidays.domain.usecases

import com.mili.features.holidays.domain.repo.IHolidaysRepository
import javax.inject.Inject

class GetDaysUseCase @Inject constructor(private val holidayRepository: IHolidaysRepository){

    fun getDaysOption() {

    }
}