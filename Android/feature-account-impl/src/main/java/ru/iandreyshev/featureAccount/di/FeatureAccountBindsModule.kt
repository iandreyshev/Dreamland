package ru.iandreyshev.featureAccount.di

import dagger.Binds
import dagger.Module
import ru.iandreyshev.featureAccount.database.IUserDatabase
import ru.iandreyshev.featureAccount.database.UserDatabase
import ru.iandreyshev.featureAccount.network.IUserServer
import ru.iandreyshev.featureAccount.network.UserServer
import javax.inject.Singleton

@Module
abstract class FeatureAccountBindsModule {

    @Binds
    @Singleton
    abstract fun bindUserDatabase(database: UserDatabase): IUserDatabase

    @Binds
    @Singleton
    abstract fun bindUserServer(server: UserServer): IUserServer

}