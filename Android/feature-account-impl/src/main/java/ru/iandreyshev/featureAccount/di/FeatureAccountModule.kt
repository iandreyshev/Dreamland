package ru.iandreyshev.featureAccount.di

import dagger.Module
import dagger.Provides
import io.reactivex.Observable
import ru.iandreyshev.featureAccount.repository.*
import ru.iandreyshev.rx.ioToMain
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

    @Provides
    @Singleton
    internal fun provideAccountObservable(repository: IUserRepository): Observable<IUser> =
            repository.getUserObservable().ioToMain()

}
