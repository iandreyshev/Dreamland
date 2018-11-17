package ru.iandreyshev.featureMenu.di.dependencies

import ru.iandreyshev.featureAccountApi.observable.IUserApi
import ru.iandreyshev.featureAccountApi.useCase.IDeleteUserUseCase
import ru.iandreyshev.featureAccountApi.useCase.IGetAuthStateUseCase
import ru.iandreyshev.featureAccountApi.useCase.ILogOutUseCase
import ru.iandreyshev.featureDreamsApi.IDreamsDiaryFragmentFactory
import ru.iandreyshev.featureDreamsApi.IDreamsRepository

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
