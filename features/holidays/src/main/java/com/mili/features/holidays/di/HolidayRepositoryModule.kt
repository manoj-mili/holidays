package com.mili.features.holidays.di

import com.mili.features.holidays.data.HolidaysRepository
import com.mili.features.holidays.data.local.HolidayDao
import com.mili.features.holidays.data.remote.HolidayAPI
import com.mili.features.holidays.domain.repo.IHolidaysRepository
import com.mili.holidays.core.DispatcherProvider
import com.mili.holidays.di.GenericRetrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class HolidayRepositoryModule {

    @Provides
    fun provideHolidayAPI(@GenericRetrofit retrofit: Retrofit): HolidayAPI {
        return retrofit.create(HolidayAPI::class.java)
    }

    @Provides
    fun provideHolidayRepository(
        dao: HolidayDao,
        holidayAPI: HolidayAPI,
        dispatcherProvider: DispatcherProvider,
    ): IHolidaysRepository =
        HolidaysRepository(holidayAPI, dao, dispatcherProvider)
}