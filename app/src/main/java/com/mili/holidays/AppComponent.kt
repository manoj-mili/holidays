package com.mili.holidays

import android.app.Application
import com.mili.core.CoreComponent
import dagger.BindsInstance
import dagger.Component

@AppScope
@Component(
    dependencies = [CoreComponent::class]
)
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application, component: CoreComponent): AppComponent
    }

    fun inject(app: BaseApplication)
}