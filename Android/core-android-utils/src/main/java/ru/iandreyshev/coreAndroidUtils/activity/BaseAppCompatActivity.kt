package ru.iandreyshev.coreAndroidUtils.activity

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.annotation.CallSuper
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity

abstract class BaseAppCompatActivity(
        @LayoutRes layout: Int
) : AppCompatActivity() {

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    protected fun <T> LiveData<T>.observe(observer: (T?) -> Unit) {
        observe(this@BaseAppCompatActivity, Observer { value ->
            value.apply(observer)
        })
    }

    protected fun <T> LiveData<T>.observeNotNull(observer: (T) -> Unit) {
        observe(this@BaseAppCompatActivity, Observer { value ->
            value?.apply(observer)
        })
    }

}
