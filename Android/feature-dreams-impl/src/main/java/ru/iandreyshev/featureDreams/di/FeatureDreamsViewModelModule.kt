package ru.iandreyshev.featureDreams.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.iandreyshev.coreAndroid.di.viewModel.MapBasedViewModelFactory
import ru.iandreyshev.coreAndroid.di.viewModel.ViewModelKey
import ru.iandreyshev.featureDreams.viewModel.DreamEditorViewModel
import ru.iandreyshev.featureDreams.viewModel.DreamListViewModel
import ru.iandreyshev.featureDreams.viewModel.ViewModelFactory
import ru.iandreyshev.featureDreams.viewModel.IViewModelFactory
import javax.inject.Singleton

@Module
abstract class FeatureDreamsViewModelModule {

    @Binds
    @Singleton
    abstract fun bindViewModelFactory(factory: MapBasedViewModelFactory): ViewModelProvider.Factory

    @Binds
    @Singleton
    abstract fun bindEditorViewModelFactory(factory: ViewModelFactory): IViewModelFactory

    @Binds
    @IntoMap
    @ViewModelKey(DreamListViewModel::class)
    abstract fun bindDreamsDiaryViewModel(viewModel: DreamListViewModel): ViewModel

}
