package ru.iandreyshev.featureAccount.di.dependencies

import ru.iandreyshev.coreAndroid.di.context.IContextProvider
import ru.iandreyshev.coreNetworkApi.api.IHttpClient

interface IFeatureAccountDependencies {
    val navigator: IAccountNavigator
    val httpClient: IHttpClient
    val contextProvider: IContextProvider
}
