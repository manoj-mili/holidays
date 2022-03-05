package com.mili.holidays.di

import com.mili.core.BuildConfig
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Dispatcher
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideOkHttp(): OkHttpClient {
        return getOkhttpClient()
    }

    @GenericRetrofit
    @Singleton
    @Provides
    fun provideRetrofitModule(okHttpClient: OkHttpClient): Retrofit {
        val moshi = Moshi.Builder()
            .build()
        return Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl("https://calendarific.com/")
            .build()
    }

    @WikiRetrofit
    @Singleton
    @Provides
    fun provideWikiRetrofitModule(): Retrofit {
        return Retrofit.Builder()
            .client(OkHttpClient())
            .baseUrl("https://en.wikipedia.org/")
            .build()
    }

    private fun getOkhttpClient(): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .dispatcher(Dispatcher())
        builder.addInterceptor { chain ->
            val request = chain.request().newBuilder()
            val originalHttpUrl = chain.request().url
            val url =
                originalHttpUrl.newBuilder().addQueryParameter("api_key", BuildConfig.API_KEY)
                    .build()
            request.url(url)
            return@addInterceptor chain.proceed(request.build())
        }
        if (BuildConfig.DEBUG) {
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            builder.addInterceptor(logging)
        }
        return builder.build()
    }
}