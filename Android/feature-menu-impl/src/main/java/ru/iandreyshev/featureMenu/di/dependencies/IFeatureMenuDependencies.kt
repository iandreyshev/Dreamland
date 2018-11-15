package ru.iandreyshev.featureMenu.di.dependencies

import android.arch.lifecycle.ViewModelProvider
import ru.iandreyshev.featureAccountApi.useCase.IGetAuthStateUseCase
import ru.iandreyshev.featureAccountApi.useCase.ILogoutUseCase
import ru.iandreyshev.featureDreamsApi.data.IDreamsDiaryFragmentFactory

interface IFeatureMenuDependencies {
    val viewModelFactory: ViewModelProvider.Factory
    val mainFragmentFactory: IDreamsDiaryFragmentFactory
    val menuNavigator: IMenuNavigator
    val splashNavigator: ISplashNavigator
    val logoutUseCase: ILogoutUseCase
    val getAuthStateUseCase: IGetAuthStateUseCase
}
