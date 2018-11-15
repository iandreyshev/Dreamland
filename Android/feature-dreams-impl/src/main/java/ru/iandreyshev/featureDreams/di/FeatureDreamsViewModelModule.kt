package ru.iandreyshev.featureDreams.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ru.iandreyshev.featureDreams.di.viewModel.ViewModelFactory
import ru.iandreyshev.featureDreams.di.viewModel.ViewModelKey
import ru.iandreyshev.featureDreams.viewModel.DreamsDiaryViewModel

@Module
class FeatureDreamsViewModelModule {

    @Provides
    @IntoMap
    @ViewModelKey(DreamsDiaryViewModel::class)
    fun bindAuthViewModel(): ViewModel = DreamsDiaryViewModel()

}
