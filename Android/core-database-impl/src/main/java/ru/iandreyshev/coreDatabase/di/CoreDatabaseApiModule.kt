package ru.iandreyshev.coreDatabase.di

import dagger.Binds
import dagger.Module
import ru.iandreyshev.coreDatabaseApi.account.IAccountDatabaseApi
import ru.iandreyshev.coreDatabase.impl.AccountDatabaseApiImpl
import javax.inject.Singleton

@Module
abstract class CoreDatabaseApiModule {

    @Binds
    @Singleton
    abstract fun bindAccountApi(coreDatabaseApiImpl: AccountDatabaseApiImpl): IAccountDatabaseApi

}
