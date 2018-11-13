package ru.iandreyshev.dreams.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.iandreyshev.dreams.di.viewModel.ViewModelFactory
import ru.iandreyshev.dreams.di.viewModel.ViewModelKey
import ru.iandreyshev.dreams.viewModel.DreamsDiaryViewModel

@Module
abstract class FeatureDreamsViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(DreamsDiaryViewModel::class)
    internal abstract fun bindAuthViewModel(viewModel: DreamsDiaryViewModel): ViewModel

}
