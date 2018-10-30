package ru.iandreyshev.featureAccount.di

import ru.iandreyshev.featureAccount.navigation.IAccountNavigator

interface IFeatureAccountDependencies {
    val navigator: IAccountNavigator
}
