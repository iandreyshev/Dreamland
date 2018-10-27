package ru.iandreyshev.dreamland.di

import dagger.Binds
import dagger.Module
import ru.iandreyshev.dreamland.navigation.ISplashNavigator
import ru.iandreyshev.dreamland.navigation.SplashNavigator

@Module
abstract class AppNavigationModule {

    @Binds
    abstract fun bindSplashNavigator(navigator: SplashNavigator): ISplashNavigator

}
