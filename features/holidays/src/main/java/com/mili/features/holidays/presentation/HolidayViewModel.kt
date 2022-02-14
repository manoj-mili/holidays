package com.mili.features.holidays.presentation

import androidx.lifecycle.ViewModel
import com.mili.features.holidays.domain.usecases.GetHolidayDetailsUseCase
import com.mili.features.holidays.domain.usecases.GetHolidayListUseCase
import javax.inject.Inject

class HolidayViewModel @Inject constructor(
    private val listHolidayUseCase: GetHolidayListUseCase,
    private val detailHolidayUseCase: GetHolidayDetailsUseCase
): ViewModel() {
}