package ru.iandreyshev.featureMenu.di.dependencies

import ru.iandreyshev.featureAccountApi.observable.IUserApi
import ru.iandreyshev.featureAccountApi.useCase.IGetAuthStateUseCase
import ru.iandreyshev.featureAccountApi.useCase.ILogOutUseCase
import ru.iandreyshev.featureDreamsApi.data.IDreamsDiaryFragmentFactory

interface IFeatureMenuDependencies {
    val mainFragmentFactory: IDreamsDiaryFragmentFactory
    val menuNavigator: IMenuNavigator
    val splashNavigator: ISplashNavigator
    val logoutUseCase: ILogOutUseCase
    val getAuthStateUseCase: IGetAuthStateUseCase
    val userApi: IUserApi
}
