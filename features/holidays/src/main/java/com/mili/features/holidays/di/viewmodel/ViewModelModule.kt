package com.mili.features.holidays.di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mili.features.holidays.presentation.HolidayViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactoryProvider: ViewModelFactoryProvider):ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(HolidayViewModel::class)
    abstract fun bindNotesViewModel(viewModel: HolidayViewModel):ViewModel
}