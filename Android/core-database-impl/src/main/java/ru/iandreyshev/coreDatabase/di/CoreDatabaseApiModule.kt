package ru.iandreyshev.coreDatabase.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import io.objectbox.BoxStore
import ru.iandreyshev.coreDatabase.entityImpl.MyObjectBox
import ru.iandreyshev.coreDatabaseApi.api.IUserDatabaseApi
import ru.iandreyshev.coreDatabase.impl.UserDatabaseApiImpl
import javax.inject.Singleton

@Module
internal abstract class CoreDatabaseApiModule {

    @Binds
    @Singleton
    abstract fun provideUserDatabaseApi(coreDatabaseApiImpl: UserDatabaseApiImpl): IUserDatabaseApi

}
