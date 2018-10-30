package ru.iandreyshev.coreNetwork.di

import dagger.Binds
import dagger.Module
import ru.iandreyshev.coreNetwork.account.AccountNetworkApiImpl
import ru.iandreyshev.coreNetworkApi.account.IAccountNetworkApi
import javax.inject.Singleton

@Module
internal abstract class CoreNetworkApiModule {

    @Binds
    @Singleton
    abstract fun bindAccountApi(coreNetworkApiImpl: AccountNetworkApiImpl): IAccountNetworkApi

}