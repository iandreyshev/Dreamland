package ru.iandreyshev.featureMenu.di.dependencies

import ru.iandreyshev.featureAccountApi.useCase.IGetAuthStateUseCase
import ru.iandreyshev.featureAccountApi.useCase.ILogoutUseCase
import ru.iandreyshev.featureDreamsApi.data.IDreamsDiaryFragmentFactory

interface IFeatureMenuDependencies {
    val mainFragmentFactory: IDreamsDiaryFragmentFactory
    val menuNavigator: IMenuNavigator
    val splashNavigator: ISplashNavigator
    val logoutUseCase: ILogoutUseCase
    val getAuthStateUseCase: IGetAuthStateUseCase
}
