package com.mili.holidays.di

import android.app.Application
import com.mili.features.countries.data.local.CountryDao
import com.mili.features.holidays.data.local.HolidayDao
import com.mili.holidays.core.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(application: Application): AppDatabase {
        return AppDatabase.getDatabase(application)
    }

    @Provides
    fun provideCountryDao(database: AppDatabase): CountryDao {
        return database.countryDao()
    }

    @Provides
    fun provideHolidayDao(database: AppDatabase): HolidayDao {
        return database.holidayDao()
    }

}