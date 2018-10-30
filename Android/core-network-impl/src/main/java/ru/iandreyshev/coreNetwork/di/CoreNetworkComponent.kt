package ru.iandreyshev.coreNetwork.di

import dagger.Component
import ru.iandreyshev.coreNetworkApi.ICoreNetworkApi
import javax.inject.Singleton

@Component(
        modules = [CoreNetworkApiModule::class]
)
@Singleton
abstract class CoreNetworkComponent : ICoreNetworkApi {

    companion object {
        fun init(component: CoreNetworkComponent) {
            sInstance = component
        }

        fun get() = sInstance

        @Volatile
        private lateinit var sInstance: CoreNetworkComponent
    }

}

