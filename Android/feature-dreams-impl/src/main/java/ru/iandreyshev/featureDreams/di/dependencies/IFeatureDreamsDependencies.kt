package ru.iandreyshev.featureDreams.di.dependencies

import android.arch.lifecycle.ViewModelProvider

interface IFeatureDreamsDependencies {
    val viewModelFactory: ViewModelProvider.Factory
}
