package ru.iandreyshev.featureAccount.di

import dagger.Binds
import dagger.Module
import ru.iandreyshev.featureAccount.useCase.GetAuthStateUseCase
import ru.iandreyshev.featureAccount.useCase.LogoutUseCase
import ru.iandreyshev.featureAccount.useCase.SignInUseCase
import ru.iandreyshev.featureAccount.useCase.SignUpUseCase
import ru.iandreyshev.featureAccountApi.useCase.IGetAuthStateUseCase
import ru.iandreyshev.featureAccountApi.useCase.ILogoutUseCase
import ru.iandreyshev.featureAccountApi.useCase.ISignInUseCase
import ru.iandreyshev.featureAccountApi.useCase.ISignUpUseCase
import javax.inject.Singleton

@Module
abstract class FeatureAccountUseCaseModule {

    @Binds
    @Singleton
    abstract fun bindSignInUseCase(useCase: SignInUseCase): ISignInUseCase

    @Binds
    @Singleton
    abstract fun bindSignUpUseCase(useCase: SignUpUseCase): ISignUpUseCase

    @Binds
    @Singleton
    abstract fun bindLogoutUseCase(useCase: LogoutUseCase): ILogoutUseCase

    @Binds
    @Singleton
    abstract fun bindGetAuthStateUseCase(useCase: GetAuthStateUseCase): IGetAuthStateUseCase

}
