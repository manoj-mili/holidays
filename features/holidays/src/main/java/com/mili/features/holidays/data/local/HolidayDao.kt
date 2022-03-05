package com.mili.features.holidays.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface HolidayDao {

    @Query("SELECT * FROM holiday WHERE country=:countryCode")
    fun getHolidayForCountry(countryCode: String): Flow<List<HolidayEntity>>

    @Query("SELECT * FROM holiday WHERE id=:holidayId")
    fun getHolidayDetailsFor(holidayId: Int): Flow<HolidayEntity>

    @Insert
    suspend fun saveHolidays(holidays: List<HolidayEntity>)
}