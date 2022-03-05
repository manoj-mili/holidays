package com.mili.holidays

import android.app.Application
import com.mili.features.countries.CountryModuleAppInstance
import com.mili.holidays.appdelegates.CountryModuleAppDelegate
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        setUpAppDelegates()
    }

    private fun setUpAppDelegates() {
        CountryModuleAppInstance.countryModuleAppDelegate = CountryModuleAppDelegate()
    }
}