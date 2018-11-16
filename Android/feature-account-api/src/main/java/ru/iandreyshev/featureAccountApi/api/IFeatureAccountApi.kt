package ru.iandreyshev.featureAccountApi.api

import ru.iandreyshev.featureAccountApi.observable.IUserApi
import ru.iandreyshev.featureAccountApi.useCase.IGetAuthStateUseCase
import ru.iandreyshev.featureAccountApi.useCase.ILogOutUseCase

interface IFeatureAccountApi {
    val logoutUseCase: ILogOutUseCase
    val getAuthStateUseCase: IGetAuthStateUseCase
    val userObservableApi: IUserApi
}
