package ru.iandreyshev.coreAndroid.viewModel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import java.lang.IllegalArgumentException

// Copyright (C) 2018 Fernando Cejas Open Source Project

inline fun <reified T : ViewModel> Fragment.viewModel(factory: ViewModelProvider.Factory, body: T.() -> Unit = {}): T {
    val vm = ViewModelProviders.of(this, factory)[T::class.java]
    vm.body()
    return vm
}

inline fun <reified T : ViewModel> Fragment.activityViewModel(factory: ViewModelProvider.Factory, body: T.() -> Unit = {}): T {
    val parentActivity = activity ?: throw IllegalArgumentException("""
        Try to take viewModel from parent activity of $this
        Parent activity is null
        """.trimIndent())

    val vm = ViewModelProviders.of(parentActivity, factory)[T::class.java]
    vm.body()
    return vm
}

inline fun <reified T : ViewModel> AppCompatActivity.viewModel(factory: ViewModelProvider.Factory, body: T.() -> Unit = {}): T {
    val vm = ViewModelProviders.of(this, factory)[T::class.java]
    vm.body()
    return vm
}
