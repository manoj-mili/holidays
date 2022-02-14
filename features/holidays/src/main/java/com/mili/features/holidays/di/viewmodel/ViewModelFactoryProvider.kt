package com.mili.features.holidays.di.viewmodel;

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mili.features.holidays.di.HolidayFeatureScope
import javax.inject.Inject
import javax.inject.Provider


@HolidayFeatureScope
class ViewModelFactoryProvider @Inject internal constructor(private val creators: kotlin.collections.Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        var creator: Provider<out ViewModel>? = creators[modelClass]
        if (creator == null) {
            for ((key, value) in creators) {
                if (modelClass.isAssignableFrom(key)) {
                    creator = value
                    break
                }
            }
        }
        requireNotNull(creator) { "unknown model class $modelClass" }
        return try {
            creator.get() as T
        } catch (e: Exception) {
            throw IllegalStateException(e)
        }
    }
}

