package ru.iandreyshev.featureAccount.di

import android.app.Application
import dagger.Module
import dagger.Provides
import ru.iandreyshev.featureAccount.repository.IAuthRepository
import ru.iandreyshev.featureAccount.repository.IUserRepository
import ru.iandreyshev.featureAccount.repository.impl.AuthRepository
import ru.iandreyshev.featureAccount.repository.impl.UserRepository
import javax.inject.Singleton

@Module
class FeatureAccountModule {

    @Provides
    @Singleton
    internal fun provideUserRepository(): IUserRepository =
            UserRepository()

    @Provides
    @Singleton
    internal fun provideAuthRepository(): IAuthRepository =
            AuthRepository()

}
