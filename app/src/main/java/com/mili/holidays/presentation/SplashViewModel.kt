package com.mili.holidays.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mili.features.countries.domain.CountryDomainModel
import com.mili.features.countries.domain.DefaultCountryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val defaultCountryUseCase: DefaultCountryUseCase
) :
    ViewModel() {
    private val _defaultCountry = MutableLiveData<CountryDomainModel>()
    private val _showSelectCountry = MutableLiveData<Unit>()
    val defaultCountry: LiveData<CountryDomainModel> = _defaultCountry
    val showSelectCountry: LiveData<Unit> = _showSelectCountry

    fun getDefaultSelectedCountry() {
        viewModelScope.launch {
            val country = defaultCountryUseCase.getDefaultCountry()
            if (country != null) {
                _defaultCountry.postValue(country)
            } else {
                _showSelectCountry.value = Unit
            }
        }
    }
}