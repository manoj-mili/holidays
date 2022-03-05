package com.mili.features.countries.di

import com.mili.features.countries.data.CountryRepository
import com.mili.features.countries.data.local.CountryDao
import com.mili.features.countries.data.remote.CountryAPI
import com.mili.features.countries.domain.ICountryRepository
import com.mili.holidays.core.DispatcherProvider
import com.mili.holidays.di.GenericRetrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class CountryRepositoryModule {

    @Provides
    fun provideCountryAPI(@GenericRetrofit retrofit: Retrofit): CountryAPI {
        return retrofit.create(CountryAPI::class.java)
    }

    @Provides
    fun provideCountryRepository(
        dao: CountryDao,
        countryAPI: CountryAPI,
        dispatcherProvider: DispatcherProvider
    ): ICountryRepository {
        return CountryRepository(dao, countryAPI, dispatcherProvider)
    }

}