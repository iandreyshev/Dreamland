package ru.iandreyshev.featureAccount.di

import dagger.Module
import dagger.Provides
import io.reactivex.Observable
import ru.iandreyshev.featureAccount.repository.*
import ru.iandreyshev.featureAccount.repository.IAuthRepository
import ru.iandreyshev.featureAccountApi.data.User
import ru.iandreyshev.featureAccount.repository.IUserRepository
import ru.iandreyshev.coreAndroid.rx.ioToMain
import javax.inject.Singleton

@Module
class FeatureAccountModule {

    @Provides
    @Singleton
    fun provideUserRepository(): IUserRepository =
            UserRepository()

    @Provides
    @Singleton
    fun provideAuthRepository(): IAuthRepository =
            AuthRepository()

    @Provides
    @Singleton
    fun provideAccountObservable(repository: IUserRepository): Observable<User> =
            repository.userObservable.ioToMain()

}
