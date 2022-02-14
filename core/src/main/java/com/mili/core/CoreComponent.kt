package com.mili.core

import dagger.Component
import retrofit2.Retrofit

@Component(
    modules = [
        NetworkModule::class
    ]
)
@CoreScope
interface CoreComponent {

    @Component.Factory
    interface Factory {
        fun create(
        ): CoreComponent
    }

    val retrofit: Retrofit
}