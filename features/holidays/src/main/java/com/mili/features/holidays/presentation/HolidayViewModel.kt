package com.mili.features.holidays.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mili.core.network.Resource
import com.mili.features.holidays.domain.models.HolidayDomainModel
import com.mili.features.holidays.domain.usecases.GetHolidayListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HolidayViewModel @Inject constructor(
    private val listHolidayUseCase: GetHolidayListUseCase
) : ViewModel() {

    private val _holidays = MutableLiveData<Resource<List<HolidayDomainModel>>>()
    val holidays: LiveData<Resource<List<HolidayDomainModel>>> = _holidays

    private val _holidayDetails = MutableLiveData<Resource<String>>()
    val holidayDetails: LiveData<Resource<String>> = _holidayDetails

    fun getHolidayList(countryCode: String) {
        viewModelScope.launch(Dispatchers.IO) {
            listHolidayUseCase.getHolidayListForCountry(countryCode)
                .collect {
                    _holidays.postValue(it)
                }
        }
    }
}