package ru.iandreyshev.coreNetwork.di

import dagger.Component
import javax.inject.Singleton

@Component
@Singleton
abstract class CoreNetworkComponent {

    companion object {
        fun init(component: CoreNetworkComponent) {
            sInstance = component
        }

        fun get() = sInstance

        @Volatile
        private lateinit var sInstance: CoreNetworkComponent
    }

}

