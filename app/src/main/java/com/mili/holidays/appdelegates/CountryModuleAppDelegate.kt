package com.mili.holidays.appdelegates

import android.content.Context
import com.mili.features.countries.ICountryModuleAppDelegate
import com.mili.features.holidays.HolidayActivity

class CountryModuleAppDelegate : ICountryModuleAppDelegate {
    override fun openHolidayActivity(context: Context, countryCode: String, countryName:String) {
        HolidayActivity.startHolidayActivity(context, countryCode, countryName)
    }
}