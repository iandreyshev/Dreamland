package ru.iandreyshev.featureAccount.di

import dagger.Binds
import dagger.Module
import ru.iandreyshev.featureAccount.api.UserObservableApi
import ru.iandreyshev.featureAccount.storage.IUserStorage
import ru.iandreyshev.featureAccount.storage.UserStorage
import ru.iandreyshev.featureAccount.network.IUserServerApi
import ru.iandreyshev.featureAccount.network.UserServerApi
import ru.iandreyshev.featureAccountApi.api.IUserApi
import javax.inject.Singleton

@Module
abstract class FeatureAccountBindsModule {

    @Binds
    @Singleton
    abstract fun bindUserStorage(storage: UserStorage): IUserStorage

    @Binds
    @Singleton
    abstract fun bindUserServer(server: UserServerApi): IUserServerApi

    @Binds
    @Singleton
    abstract fun bindUserObservableApi(userObservableApi: UserObservableApi): IUserApi

}