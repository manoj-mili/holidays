package com.mili.holidays

import android.app.Application
import com.mili.core.CoreComponent
import com.mili.core.CoreComponentProvider
import com.mili.core.DaggerCoreComponent
import retrofit2.Retrofit
import javax.inject.Inject

class BaseApplication : Application(), CoreComponentProvider {

    @Inject
    lateinit var retrofit: Retrofit
    private lateinit var coreComponent: CoreComponent

    override fun onCreate() {
        super.onCreate()
        coreComponent = DaggerCoreComponent.factory().create()
        DaggerAppComponent.factory().create(this, coreComponent).inject(this)
    }

    override fun provideCoreComponent(): CoreComponent {
        return coreComponent
    }
}