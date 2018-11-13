package ru.iandreyshev.coreDatabase.di

import dagger.Component
import ru.iandreyshev.coreDatabase.di.dependencies.IContextProvider
import ru.iandreyshev.coreDatabase.di.dependencies.ICoreDatabaseDependencies
import ru.iandreyshev.coreDatabaseApi.ICoreDatabaseApi
import javax.inject.Singleton

@Component(
        modules = [
            CoreDatabaseApiModule::class,
            CoreDatabaseModule::class],
        dependencies = [
            ICoreDatabaseDependencies::class]
)
@Singleton
abstract class CoreDatabaseComponent : ICoreDatabaseApi {

    @Component(
            dependencies = [
                IContextProvider::class]
    )
    abstract class DependenciesComponent : ICoreDatabaseDependencies

    companion object {
        fun init(component: CoreDatabaseComponent) {
            sInstance = component
        }

        fun get(): CoreDatabaseComponent = sInstance

        @Volatile
        private lateinit var sInstance: CoreDatabaseComponent
    }

}
