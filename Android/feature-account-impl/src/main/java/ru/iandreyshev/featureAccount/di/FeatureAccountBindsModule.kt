package ru.iandreyshev.featureAccount.di

import dagger.Binds
import dagger.Module
import ru.iandreyshev.featureAccount.api.UserObservableApi
import ru.iandreyshev.featureAccount.database.IUserDatabase
import ru.iandreyshev.featureAccount.database.UserDatabase
import ru.iandreyshev.featureAccount.network.IUserServerApi
import ru.iandreyshev.featureAccount.network.UserServerApi
import ru.iandreyshev.featureAccountApi.observable.IUserApi
import javax.inject.Singleton

@Module
abstract class FeatureAccountBindsModule {

    @Binds
    @Singleton
    abstract fun bindUserDatabase(database: UserDatabase): IUserDatabase

    @Binds
    @Singleton
    abstract fun bindUserServer(server: UserServerApi): IUserServerApi

    @Binds
    @Singleton
    abstract fun bindUserObservableApi(userObservableApi: UserObservableApi): IUserApi

}