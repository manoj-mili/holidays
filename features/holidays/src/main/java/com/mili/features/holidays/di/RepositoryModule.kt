package com.mili.features.holidays.di

import com.mili.core.mapper.IDataMapper
import com.mili.features.holidays.data.HolidayAPI
import com.mili.features.holidays.data.HolidayMapper
import com.mili.features.holidays.data.HolidaysRepository
import com.mili.features.holidays.data.models.HolidayResponse
import com.mili.features.holidays.domain.models.HolidayDomainModel
import com.mili.features.holidays.domain.repo.IHolidaysRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class RepositoryModule {

    @Provides
    @HolidayFeatureScope
    fun provideHolidayAPI(retrofit: Retrofit): HolidayAPI {
        return retrofit.create(HolidayAPI::class.java)
    }

    @Provides
    @HolidayFeatureScope
    fun provideHolidayMapper(): IDataMapper<HolidayResponse, List<HolidayDomainModel>> {
        return HolidayMapper()
    }

    @Provides
    @HolidayFeatureScope
    fun provideHolidayRepository(holidaysRepository: HolidaysRepository): IHolidaysRepository =
        holidaysRepository
}