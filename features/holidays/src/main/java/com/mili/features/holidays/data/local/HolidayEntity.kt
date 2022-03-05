package com.mili.features.holidays.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "holiday")
class HolidayEntity(
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "description")
    val description: String,
    @ColumnInfo(name = "date")
    val date: String,
    @ColumnInfo(name = "type")
    val types: String, // will store comma separated string (other approach is to use converters)
    @ColumnInfo(name = "country")
    val country: String,
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int = 0
)