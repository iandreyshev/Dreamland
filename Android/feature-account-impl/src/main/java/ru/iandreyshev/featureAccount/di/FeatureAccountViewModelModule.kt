package ru.iandreyshev.featureAccount.di

import android.arch.lifecycle.ViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ru.iandreyshev.featureDreams.di.viewModel.ViewModelKey
import ru.iandreyshev.featureAccount.viewModel.AuthViewModel
import ru.iandreyshev.featureAccount.viewModel.SignInViewModel
import ru.iandreyshev.featureAccount.viewModel.SignUpViewModel

@Module
class FeatureAccountViewModelModule {

    @Provides
    @IntoMap
    @ViewModelKey(AuthViewModel::class)
    fun provideAuthViewModel(): ViewModel = AuthViewModel()

    @Provides
    @IntoMap
    @ViewModelKey(SignInViewModel::class)
    fun provideSignInViewModel(): ViewModel = SignInViewModel()

    @Provides
    @IntoMap
    @ViewModelKey(SignUpViewModel::class)
    fun provideSignUpViewModel(): ViewModel = SignUpViewModel()

}
