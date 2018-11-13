package ru.iandreyshev.featureAccount.di

import ru.iandreyshev.coreDatabaseApi.account.IAccountDatabaseApi
import ru.iandreyshev.coreNetworkApi.account.IAccountNetworkApi
import ru.iandreyshev.featureAccount.navigation.IAccountNavigator

interface IFeatureAccountDependencies {
    val navigator: IAccountNavigator
    val accountDatabaseApi: IAccountDatabaseApi
    val accountNetworkApi: IAccountNetworkApi
}
