package com.mili.features.holidays.domain.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class HolidayDomainModel(
    val holidayId: Int,
    val holidayName: String,
    val holidayDate: String,
    val holidayDay: String,
    val isNationalHoliday: Boolean,
    val isLongWeekend: Boolean,
    val country: String,
    val description: String,
    val types:List<String>
):Parcelable