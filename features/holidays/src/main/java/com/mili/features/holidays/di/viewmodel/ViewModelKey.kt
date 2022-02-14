package com.mili.features.holidays.di.viewmodel;

import androidx.lifecycle.ViewModel
import dagger.MapKey
import java.lang.annotation.Documented
import kotlin.reflect.KClass


/** The interface View model key.  */
@Documented
@kotlin.annotation.Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(
    /**
     * Value class.
     *
     * @return the class
     */
    val value: KClass<out ViewModel>
)