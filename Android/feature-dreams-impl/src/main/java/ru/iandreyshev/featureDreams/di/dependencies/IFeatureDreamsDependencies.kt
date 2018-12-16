package ru.iandreyshev.featureDreams.di.dependencies

import ru.iandreyshev.coreAndroid.di.context.IContextProvider
import ru.iandreyshev.coreNetworkApi.api.IHttpClient
import ru.iandreyshev.featureAccountApi.api.IUserApi
import ru.iandreyshev.featureAccountApi.useCase.ILogOutUseCase

interface IFeatureDreamsDependencies {
    val contextProvider: IContextProvider
    val userApi: IUserApi
    val logoutUseCase: ILogOutUseCase
    val httpClient: IHttpClient
}
