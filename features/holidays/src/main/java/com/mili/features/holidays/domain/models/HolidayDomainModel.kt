package com.mili.features.holidays.domain.models

data class HolidayDomainModel(
    private val holidayId: Int,
    private val holidayName: String,
    private val holidayDate: String,
    private val holidayDay: String,
    private val isNationalHoliday: Boolean,
    private val isLongWeekend: Boolean,
    private val country: String
) {
}