package ru.iandreyshev.coreDatabase.di

import dagger.Component
import ru.iandreyshev.coreDatabase.api.ICoreDatabaseApi
import javax.inject.Singleton

@Component(
        modules = [CoreDatabaseModule::class]
)
@Singleton
abstract class CoreDatabaseComponent : ICoreDatabaseApi {

    companion object {
        fun init(component: CoreDatabaseComponent) {
            sInstance = component
        }

        fun get() = sInstance

        @Volatile
        private lateinit var sInstance: CoreDatabaseComponent
    }

}
