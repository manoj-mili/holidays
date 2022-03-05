package com.mili.holidays

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.mili.features.countries.CountrySelectionActivity.Companion.startCountrySelection
import com.mili.features.holidays.HolidayActivity.Companion.startHolidayActivity
import com.mili.holidays.presentation.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val splashViewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        observeDataChanges()
        splashViewModel.getDefaultSelectedCountry()
    }

    private fun observeDataChanges() {
        splashViewModel.defaultCountry.observe(this, {
            startHolidayActivity(this,it.code, it.countryName)
        })

        splashViewModel.showSelectCountry.observe(this, {
            startCountrySelection(this)
            finish()
        })
    }
}