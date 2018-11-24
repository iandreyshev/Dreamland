package ru.iandreyshev.featureAccount.di.dependencies

import ru.iandreyshev.coreNetworkApi.api.IHttpClient

interface IFeatureAccountDependencies {
    val contextProvider: IContextProvider
    val navigator: IAccountNavigator
    val httpClient: IHttpClient
}
