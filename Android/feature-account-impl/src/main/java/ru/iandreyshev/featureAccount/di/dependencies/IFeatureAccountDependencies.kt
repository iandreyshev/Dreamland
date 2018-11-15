package ru.iandreyshev.featureAccount.di.dependencies

import android.arch.lifecycle.ViewModelProvider

interface IFeatureAccountDependencies {
    val viewModelFactory: ViewModelProvider.Factory
    val navigator: IAccountNavigator
}
