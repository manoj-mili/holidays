package com.mili.features.countries

import android.content.Context

interface ICountryModuleAppDelegate {

    fun openHolidayActivity(context: Context, countryCode:String, countryName:String)
}