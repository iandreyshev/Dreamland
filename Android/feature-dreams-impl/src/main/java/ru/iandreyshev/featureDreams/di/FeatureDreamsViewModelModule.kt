package ru.iandreyshev.featureDreams.di

import android.arch.lifecycle.ViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ru.iandreyshev.featureDreams.di.viewModel.ViewModelKey
import ru.iandreyshev.featureDreams.viewModel.DreamConstructorViewModel
import ru.iandreyshev.featureDreams.viewModel.DreamsDiaryViewModel

@Module
class FeatureDreamsViewModelModule {

    @Provides
    @IntoMap
    @ViewModelKey(DreamsDiaryViewModel::class)
    fun bindDreamsDiaryViewModel(): ViewModel = DreamsDiaryViewModel()

    @Provides
    @IntoMap
    @ViewModelKey(DreamConstructorViewModel::class)
    fun bindDreamConstructorViewModel(): ViewModel = DreamConstructorViewModel()

}
