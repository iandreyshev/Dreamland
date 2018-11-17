package ru.iandreyshev.featureAccount.di

import dagger.Binds
import dagger.Module
import ru.iandreyshev.featureAccount.useCase.*
import ru.iandreyshev.featureAccountApi.useCase.*
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
    abstract fun bindLogoutUseCase(useCase: LogOutUseCase): ILogOutUseCase

    @Binds
    @Singleton
    abstract fun bindGetAuthStateUseCase(useCase: GetAuthStateUseCase): IGetAuthStateUseCase

    @Binds
    @Singleton
    abstract fun bindDeleteUserUseCase(useCase: DeleteUserUseCase): IDeleteUserUseCase

}
