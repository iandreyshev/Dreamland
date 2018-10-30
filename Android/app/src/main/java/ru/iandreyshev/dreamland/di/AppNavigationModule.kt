package ru.iandreyshev.dreamland.di

import dagger.Binds
import dagger.Module
import ru.iandreyshev.dreamland.navigation.FeatureAccountNavigator
import ru.iandreyshev.dreamland.navigation.ISplashNavigator
import ru.iandreyshev.dreamland.navigation.FeatureMenuNavigator
import ru.iandreyshev.dreamland.navigation.SplashNavigator
import ru.iandreyshev.featureAccountApi.IAccountNavigator
import ru.iandreyshev.featureMenuApi.navigation.IMenuNavigator

@Module
abstract class AppNavigationModule {

    @Binds
    abstract fun bindSplashNavigator(navigator: SplashNavigator): ISplashNavigator

    @Binds
    abstract fun bindMenuNavigator(navigator: FeatureMenuNavigator): IMenuNavigator

    @Binds
    abstract fun bindAuthNavigator(navigator: FeatureAccountNavigator): IAccountNavigator

}
