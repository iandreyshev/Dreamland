package ru.iandreyshev.dreamland.di

import dagger.Binds
import dagger.Module
import ru.iandreyshev.dreamland.navigation.FeatureAccountNavigator
import ru.iandreyshev.dreamland.navigation.FeatureMenuSplashNavigator
import ru.iandreyshev.featureAccount.di.dependencies.IAccountNavigator
import ru.iandreyshev.featureMenu.di.dependencies.ISplashNavigator

@Module
abstract class AppNavigationModule {

    @Binds
    abstract fun bindSplashNavigator(navigator: FeatureMenuSplashNavigator): ISplashNavigator

    @Binds
    abstract fun bindAuthNavigator(navigator: FeatureAccountNavigator): IAccountNavigator

}
