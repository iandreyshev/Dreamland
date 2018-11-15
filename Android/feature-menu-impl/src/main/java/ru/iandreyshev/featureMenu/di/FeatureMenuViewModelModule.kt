package ru.iandreyshev.featureMenu.di

import android.arch.lifecycle.ViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ru.iandreyshev.featureDreams.di.viewModel.ViewModelKey
import ru.iandreyshev.featureMenu.viewModel.MenuViewModel
import ru.iandreyshev.featureMenu.viewModel.SplashViewModel

@Module
class FeatureMenuViewModelModule {

    @Provides
    @IntoMap
    @ViewModelKey(MenuViewModel::class)
    fun bindMenuViewModel(): ViewModel = MenuViewModel()

    @Provides
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    fun bindSplashViewModel(): ViewModel = SplashViewModel()

}
