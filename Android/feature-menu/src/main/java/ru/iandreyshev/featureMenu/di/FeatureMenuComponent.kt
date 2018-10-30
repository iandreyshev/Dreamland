package ru.iandreyshev.featureMenu.di

import dagger.Component
import ru.iandreyshev.activity.BaseAppCompatActivity
import ru.iandreyshev.coreDatabase.api.ICoreDatabaseApi
import ru.iandreyshev.featureMenu.navigation.IMenuNavigator
import javax.inject.Singleton

@Component(
        modules = [
            FeatureMenuModule::class,
            FeatureMenuViewModelModule::class],
        dependencies = [IFeatureMenuDependencies::class]
)
@Singleton
abstract class FeatureMenuComponent {

    companion object {
        fun init(component: FeatureMenuComponent) {
            sInstance = component
        }

        fun get() = sInstance

        @Volatile
        private lateinit var sInstance: FeatureMenuComponent
    }

    abstract fun inject(activity: BaseAppCompatActivity)

    @Component(
            dependencies = [
                IMenuNavigator::class,
                ICoreDatabaseApi::class]
    )
    interface DependenciesComponent : IFeatureMenuDependencies

}
