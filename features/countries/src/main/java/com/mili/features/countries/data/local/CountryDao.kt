package com.mili.features.countries.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CountryDao {

    @Query("UPDATE country SET is_default= CASE id WHEN :countryId THEN 1 ELSE 0 END")
    suspend fun updateDefaultCountry(countryId: String)

    @Query("SELECT * FROM country")
    fun getCountries(): Flow<List<CountryEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCountries(countries: List<CountryEntity>)

    @Query("SELECT * FROM country WHERE is_default = 1")
    suspend fun getDefaultCountry(): CountryEntity?
}