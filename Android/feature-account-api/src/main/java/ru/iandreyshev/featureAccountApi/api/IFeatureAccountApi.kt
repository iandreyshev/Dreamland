package ru.iandreyshev.featureAccountApi.api

import ru.iandreyshev.featureAccountApi.useCase.IGetAuthStateUseCase
import ru.iandreyshev.featureAccountApi.useCase.ILogoutUseCase

interface IFeatureAccountApi {
    val logoutUseCase: ILogoutUseCase
    val getAuthStateUseCase: IGetAuthStateUseCase
}
