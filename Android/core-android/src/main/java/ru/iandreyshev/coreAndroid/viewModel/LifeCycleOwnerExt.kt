package ru.iandreyshev.coreAndroid.viewModel

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer

fun <T> LifecycleOwner.observe(liveData: LiveData<T>, observer: (T?) -> Unit) =
        liveData.observe(this@observe, Observer { value ->
            value.apply(observer)
        })

fun <T> LifecycleOwner.observeNotNull(liveData: LiveData<T>, observer: (T) -> Unit) =
        liveData.observe(this@observeNotNull, Observer { value ->
            value?.apply(observer)
        })
