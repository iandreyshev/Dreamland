package ru.iandreyshev.featureAccount.di.dependencies

import ru.iandreyshev.coreNetworkApi.ICoreNetworkApi

interface IFeatureAccountDependencies {
    val contextProvider: IContextProvider
    val navigator: IAccountNavigator
    val networkApi: ICoreNetworkApi
}
