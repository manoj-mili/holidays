package com.mili.holidays.di

import com.mili.holidays.core.DefaultDispatcherProvider
import com.mili.holidays.core.DispatcherProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DispatcherModule {

    @Provides
    fun bindDispatcherModule(): DispatcherProvider = DefaultDispatcherProvider()
}