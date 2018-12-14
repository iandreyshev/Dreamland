package ru.iandreyshev.featureAccountApi.api

import ru.iandreyshev.featureAccountApi.useCase.IDeleteUserUseCase
import ru.iandreyshev.featureAccountApi.useCase.IStartUpUseCase
import ru.iandreyshev.featureAccountApi.useCase.ILogOutUseCase

interface IFeatureAccountApi {
    val logoutUseCase: ILogOutUseCase
    val getAuthStateUseCase: IStartUpUseCase
    val deleteUserUseCase: IDeleteUserUseCase
    val userObservableApi: IUserApi
}
