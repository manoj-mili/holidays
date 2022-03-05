package com.mili.features.countries.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "country")
class CountryEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,
    @ColumnInfo(name = "total_holidays")
    val totalHolidays: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "flag_url")
    val flagURL: String,
    @ColumnInfo(name = "is_default")
    val isDefault: Boolean,
    @ColumnInfo(name = "code")
    val countryCode: String
)