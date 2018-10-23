package ru.iandreyshev.dreamland.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.iandreyshev.di.viewModel.ViewModelFactory
import ru.iandreyshev.di.viewModel.ViewModelKey
import ru.iandreyshev.dreamland.viewModel.main.MainViewModel
import ru.iandreyshev.dreamland.viewModel.menu.MenuViewModel

@Module
internal abstract class AppViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindsMainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MenuViewModel::class)
    abstract fun bindsMenuViewModel(viewModel: MenuViewModel): ViewModel

}