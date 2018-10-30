package ru.iandreyshev.featureMenu.di

import ru.iandreyshev.coreDatabase.api.ICoreDatabaseApi
import ru.iandreyshev.coreDatabase.api.IUserDatabaseApi
import ru.iandreyshev.featureMenu.navigation.IMenuNavigator

interface IFeatureMenuDependencies {
    val navigator: IMenuNavigator
    val databaseApi: IUserDatabaseApi
}
