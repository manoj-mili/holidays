package com.mili.features.holidays.di

import com.mili.core.CoreComponent
import com.mili.features.holidays.HolidayActivity
import com.mili.features.holidays.di.viewmodel.ViewModelModule
import dagger.Component

@Component(
    dependencies = [CoreComponent::class],
    modules = [RepositoryModule::class, ViewModelModule::class]
)
@HolidayFeatureScope
interface HolidayComponent {

    @Component.Factory
    interface Factory {
        fun create(
            coreComponent: CoreComponent
        ): HolidayComponent
    }

    fun inject(activity: HolidayActivity): HolidayActivity

}