package ru.iandreyshev.dreamland.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.iandreyshev.dreams.di.viewModel.ViewModelFactory
import ru.iandreyshev.dreams.di.viewModel.ViewModelKey
import ru.iandreyshev.dreamland.viewModel.SplashViewModel
import ru.iandreyshev.featureMenu.viewModel.MenuViewModel

@Module
internal abstract class AppViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    internal abstract fun bindSplashViewModel(viewModel: SplashViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MenuViewModel::class)
    internal abstract fun bindMenuViewModel(viewModel: MenuViewModel): ViewModel

}
