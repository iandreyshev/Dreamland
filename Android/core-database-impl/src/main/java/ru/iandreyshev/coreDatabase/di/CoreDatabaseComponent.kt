package ru.iandreyshev.coreDatabase.di

import android.content.Context
import dagger.Component
import ru.iandreyshev.coreDatabaseApi.ICoreDatabaseApi
import javax.inject.Singleton

@Component(
        modules = [
            CoreDatabaseApiModule::class,
            CoreDatabaseModule::class],
        dependencies = [
            Context::class]
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
