package ru.iandreyshev.coreNetwork.di

import dagger.Binds
import dagger.Module
import ru.iandreyshev.coreNetwork.httpClient.HttpClient
import ru.iandreyshev.coreNetworkApi.IHttpClient
import javax.inject.Singleton

@Module
abstract class CoreNetworkApiModule {

    @Binds
    @Singleton
    abstract fun bindHttpClient(httpClient: HttpClient): IHttpClient

}
