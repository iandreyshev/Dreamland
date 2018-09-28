package ru.iandreyshev.coreAndroidUtils

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer

fun <T> liveDataOf(default: T? = null): LiveData<T> = MutableLiveData<T>().also {
    it.value = default
}

fun <T> mutableLiveDataOf(default: T? = null) = MutableLiveData<T>().also {
    it.value = default
}

fun <T> LiveData<T>.observeNotNull(lifecycleOwner: LifecycleOwner, observer: (T) -> Unit) {
    observe(lifecycleOwner, Observer {
        if (it != null) {
            observer.invoke(it)
        }
    })
}
