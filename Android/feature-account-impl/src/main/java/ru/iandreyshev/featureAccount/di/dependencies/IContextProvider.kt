package ru.iandreyshev.featureAccount.di.dependencies

import android.content.Context

interface IContextProvider {
    val applicationContext: Context
}