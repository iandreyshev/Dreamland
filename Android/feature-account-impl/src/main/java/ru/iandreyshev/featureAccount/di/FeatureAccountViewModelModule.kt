package ru.iandreyshev.featureAccount.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.iandreyshev.coreAndroid.di.viewModel.ViewModelKey
import ru.iandreyshev.featureAccount.viewModel.AuthViewModel
import ru.iandreyshev.featureAccount.viewModel.SignInViewModel
import ru.iandreyshev.featureAccount.viewModel.SignUpViewModel
import ru.iandreyshev.coreAndroid.di.viewModel.MapBasedViewModelFactory
import javax.inject.Singleton

@Module
abstract class FeatureAccountViewModelModule {

    @Binds
    @Singleton
    abstract fun bindViewModelFactory(factory: MapBasedViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel::class)
    abstract fun provideAuthViewModel(viewModel: AuthViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SignInViewModel::class)
    @Singleton
    abstract fun provideSignInViewModel(viewModel: SignInViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SignUpViewModel::class)
    abstract fun provideSignUpViewModel(viewModel: SignUpViewModel): ViewModel

}
