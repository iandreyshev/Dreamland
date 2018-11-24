package ru.iandreyshev.featureMenu.di.dependencies

import ru.iandreyshev.featureAccountApi.api.IUserApi
import ru.iandreyshev.featureAccountApi.useCase.IDeleteUserUseCase
import ru.iandreyshev.featureAccountApi.useCase.IGetAuthStateUseCase
import ru.iandreyshev.featureAccountApi.useCase.ILogOutUseCase
import ru.iandreyshev.featureDreamsApi.api.IDreamsDiaryFragmentFactory
import ru.iandreyshev.featureDreamsApi.api.IDreamsRepository

interface IFeatureMenuDependencies {
    val mainFragmentFactory: IDreamsDiaryFragmentFactory
    val menuNavigator: IMenuNavigator
    val splashNavigator: ISplashNavigator
    val logoutUseCase: ILogOutUseCase
    val getAuthStateUseCase: IGetAuthStateUseCase
    val deleteUserUseCase: IDeleteUserUseCase
    val dreamsRepository: IDreamsRepository
    val userApi: IUserApi
}
