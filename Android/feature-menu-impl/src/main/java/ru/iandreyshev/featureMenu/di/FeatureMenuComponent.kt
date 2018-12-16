package ru.iandreyshev.featureMenu.di

import dagger.Component
import ru.iandreyshev.featureAccountApi.api.IFeatureAccountApi
import ru.iandreyshev.featureDreamsApi.api.IFeatureDreamsApi
import ru.iandreyshev.featureMenu.di.dependencies.IFeatureMenuDependencies
import ru.iandreyshev.featureMenu.di.dependencies.IMenuNavigator
import ru.iandreyshev.featureMenu.di.dependencies.ISplashNavigator
import ru.iandreyshev.featureMenu.presentation.activity.MenuActivity
import ru.iandreyshev.featureMenu.presentation.activity.SplashActivity
import ru.iandreyshev.featureMenu.presentation.fragment.SettingsFragment
import javax.inject.Singleton

@Component(
        modules = [
            FeatureMenuViewModelModule::class,
            FeatureMenuUseCaseModule::class],
        dependencies = [
            IFeatureMenuDependencies::class]
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

    abstract fun inject(activity: MenuActivity)
    abstract fun inject(activity: SplashActivity)
    abstract fun inject(fragment: SettingsFragment)

    @Component(
            dependencies = [
                IFeatureAccountApi::class,
                IFeatureDreamsApi::class,
                ISplashNavigator::class,
                IMenuNavigator::class]
    )
    abstract class DependenciesComponent : IFeatureMenuDependencies

}
