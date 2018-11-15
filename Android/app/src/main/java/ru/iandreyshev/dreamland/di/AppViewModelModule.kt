package ru.iandreyshev.dreamland.di

import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import ru.iandreyshev.featureDreams.di.viewModel.ViewModelFactory
import javax.inject.Singleton

@Module
internal abstract class AppViewModelModule {

    @Binds
    @Singleton
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}
