package ru.iandreyshev.featureDreams.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.iandreyshev.coreAndroid.di.viewModel.ViewModelFactory
import ru.iandreyshev.coreAndroid.di.viewModel.ViewModelKey
import ru.iandreyshev.featureDreams.viewModel.EditDreamViewModel
import ru.iandreyshev.featureDreams.viewModel.DreamListViewModel
import javax.inject.Singleton

@Module
abstract class FeatureDreamsViewModelModule {

    @Binds
    @Singleton
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(DreamListViewModel::class)
    abstract fun bindDreamsDiaryViewModel(viewModel: DreamListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(EditDreamViewModel::class)
    abstract fun bindDreamConstructorViewModel(viewModel: EditDreamViewModel): ViewModel

}
