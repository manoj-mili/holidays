package com.mili.core

import dagger.Module
import dagger.Provides
import okhttp3.Dispatcher
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @CoreScope
    @Provides
    fun provideOkHttp(): OkHttpClient {
        return getOkhttpClient()
    }

    @CoreScope
    @Provides
    fun provideRetrofitModule(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl("https://baseurl.com")
            .build()
    }

    private fun getOkhttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .dispatcher(Dispatcher())
        if (BuildConfig.DEBUG) {
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            builder.addInterceptor(logging)
        }
        return builder.build()
    }
}