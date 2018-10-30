package ru.iandreyshev.coreDatabase.di

import dagger.Binds
import dagger.Module
import ru.iandreyshev.coreDatabase.api.IUserDatabaseApi
import ru.iandreyshev.coreDatabase.impl.UserDatabaseApiImpl
import javax.inject.Singleton

@Module
internal abstract class CoreDatabaseModule {

    @Binds
    @Singleton
    abstract fun provideUserDatabaseApi(coreDatabaseApiImpl: UserDatabaseApiImpl): IUserDatabaseApi

}
