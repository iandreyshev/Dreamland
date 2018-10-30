package ru.iandreyshev.featureMenu.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.iandreyshev.di.viewModel.ViewModelFactory
import ru.iandreyshev.di.viewModel.ViewModelKey
import ru.iandreyshev.featureMenu.viewModel.MenuViewModel

@Module
internal abstract class FeatureMenuViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MenuViewModel::class)
    abstract fun bindMenuViewModel(viewModel: MenuViewModel): ViewModel

}
