package com.mili.features.holidays

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.mili.core.InjectUtils
import com.mili.features.holidays.di.DaggerHolidayComponent
import com.mili.features.holidays.di.viewmodel.ViewModelFactoryProvider
import com.mili.features.holidays.presentation.HolidayViewModel
import javax.inject.Inject

class HolidayActivity : AppCompatActivity() {
    private val TAG = "HolidayActivity"

    @Inject
    lateinit var viewModelFactoryProvider: ViewModelFactoryProvider

    lateinit var viewModel: HolidayViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_holiday)
        val coreComponent = InjectUtils.provideBaseComponent(applicationContext)
        DaggerHolidayComponent.factory().create(coreComponent).inject(this)
        viewModel =
            ViewModelProvider(this, viewModelFactoryProvider).get(HolidayViewModel::class.java)
    }
}