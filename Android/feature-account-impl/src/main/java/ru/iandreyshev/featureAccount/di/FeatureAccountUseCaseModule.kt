package ru.iandreyshev.featureAccount.di

import dagger.Module
import dagger.Provides
import ru.iandreyshev.featureAccount.useCase.GetAuthStateUseCase
import ru.iandreyshev.featureAccount.useCase.LogoutUseCase
import ru.iandreyshev.featureAccount.useCase.SignInUseCase
import ru.iandreyshev.featureAccountApi.useCase.IGetAuthStateUseCase
import ru.iandreyshev.featureAccountApi.useCase.ILogoutUseCase
import ru.iandreyshev.featureAccountApi.useCase.ISignInUseCase

@Module
class FeatureAccountUseCaseModule {

    @Provides
    fun provideSignInUseCase(): ISignInUseCase =
            SignInUseCase()

    @Provides
    fun provideLogoutUseCase(): ILogoutUseCase =
            LogoutUseCase()

    @Provides
    fun provideGetAuthStateUseCase(): IGetAuthStateUseCase =
            GetAuthStateUseCase()

}
