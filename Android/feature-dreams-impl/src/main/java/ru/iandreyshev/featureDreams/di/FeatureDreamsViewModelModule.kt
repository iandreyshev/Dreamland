package ru.iandreyshev.featureDreams.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.iandreyshev.featureDreams.di.viewModel.ViewModelFactory
import ru.iandreyshev.featureDreams.di.viewModel.ViewModelKey
import ru.iandreyshev.featureDreams.viewModel.DreamConstructorViewModel
import ru.iandreyshev.featureDreams.viewModel.DreamsDiaryViewModel
import javax.inject.Singleton

@Module
abstract class FeatureDreamsViewModelModule {

    @Binds
    @Singleton
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(DreamsDiaryViewModel::class)
    abstract fun bindDreamsDiaryViewModel(viewModel: DreamsDiaryViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DreamConstructorViewModel::class)
    abstract fun bindDreamConstructorViewModel(viewModel: DreamConstructorViewModel): ViewModel

}
