package com.mili.features.countries.presentation

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mili.core.network.Resource
import com.mili.features.countries.CountryModuleAppInstance
import com.mili.features.countries.domain.CountryDomainModel
import com.mili.features.countries.domain.DefaultCountryUseCase
import com.mili.features.countries.domain.FetchCountriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountryViewModel @Inject constructor(
    private val defaultCountryUseCase: DefaultCountryUseCase,
    private val fetchCountriesUseCase: FetchCountriesUseCase
) :
    ViewModel() {
    private val appDelegate = CountryModuleAppInstance.countryModuleAppDelegate

    private val _countries = MutableLiveData<Resource<List<CountryDomainModel>>>()
    val countries: LiveData<Resource<List<CountryDomainModel>>> = _countries

    fun getCountries() {
        viewModelScope.launch(Dispatchers.IO) {
            fetchCountriesUseCase.getCountries().collect {
                _countries.postValue(it)
            }
        }
    }

    fun updateDefaultCountry(countryDomainModel: CountryDomainModel, context: Context) {
        viewModelScope.launch {
            defaultCountryUseCase.updateDefaultCountry(countryDomainModel.countryId)
            appDelegate?.openHolidayActivity(context, countryDomainModel.code, countryDomainModel.countryName)
        }
    }

}