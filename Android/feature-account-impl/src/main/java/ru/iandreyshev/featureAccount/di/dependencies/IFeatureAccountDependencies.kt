package ru.iandreyshev.featureAccount.di.dependencies

import ru.iandreyshev.coreAndroid.di.context.IContextProvider
import ru.iandreyshev.coreNetworkApi.api.IHttpClient
import ru.iandreyshev.featureDreamsApi.useCase.IClearDreamsStorageUseCase

interface IFeatureAccountDependencies {
    val navigator: IAccountNavigator
    val httpClient: IHttpClient
    val contextProvider: IContextProvider
    val clearDreamsStorageUseCase: IClearDreamsStorageUseCase
}
