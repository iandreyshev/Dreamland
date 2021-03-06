package ru.iandreyshev.featureAccountApi.api

import ru.iandreyshev.featureAccountApi.useCase.IDeleteUserUseCase
import ru.iandreyshev.featureAccountApi.useCase.ILogOutUseCase

interface IFeatureAccountApi {
    val logoutUseCase: ILogOutUseCase
    val deleteUserUseCase: IDeleteUserUseCase
    val userObservableApi: IUserApi
}
