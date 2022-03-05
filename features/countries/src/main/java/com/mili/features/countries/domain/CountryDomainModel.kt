package com.mili.features.countries.domain

data class CountryDomainModel(
    val countryId: String,
    val countryName: String,
    val flagURL: String,
    val totalHolidays: Int,
    val isSelected: Boolean,
    val code:String
)
