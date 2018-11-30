package ru.iandreyshev.featureMenu.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.iandreyshev.coreAndroid.di.viewModel.MapBasedViewModelFactory
import ru.iandreyshev.coreAndroid.di.viewModel.ViewModelKey
import ru.iandreyshev.featureMenu.viewModel.MenuViewModel
import ru.iandreyshev.featureMenu.viewModel.SettingsViewModel
import ru.iandreyshev.featureMenu.viewModel.SplashViewModel
import javax.inject.Singleton

@Module
abstract class FeatureMenuViewModelModule {

    @Binds
    @Singleton
    abstract fun bindViewModelFactory(factory: MapBasedViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MenuViewModel::class)
    abstract fun bindMenuViewModel(viewModel: MenuViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    abstract fun bindSplashViewModel(viewModel: SplashViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SettingsViewModel::class)
    abstract fun bindSettingsViewModel(viewModel: SettingsViewModel): ViewModel

}
