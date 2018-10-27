package ru.iandreyshev.featureAccount.di

import dagger.Binds
import dagger.Module
import ru.iandreyshev.featureAccount.useCase.BackFromAccountUseCase
import ru.iandreyshev.featureAccount.useCase.IBackFromAccountUseCase
import ru.iandreyshev.featureAccount.useCase.IRefreshUserUseCase
import ru.iandreyshev.featureAccount.useCase.RefreshUserUseCase

@Module
abstract class FeatureAccountUseCaseModule {

    @Binds
    internal abstract fun bindRefreshUseCase(useCase: RefreshUserUseCase): IRefreshUserUseCase

    @Binds
    internal abstract fun bindBackFromAccountUseCase(useCase: BackFromAccountUseCase): IBackFromAccountUseCase

}