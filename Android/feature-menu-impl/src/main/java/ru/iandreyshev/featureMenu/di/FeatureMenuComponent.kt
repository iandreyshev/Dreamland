package ru.iandreyshev.featureMenu.di

import dagger.Component
import ru.iandreyshev.featureMenu.presentation.activity.MenuActivity
import ru.iandreyshev.featureMenuApi.navigation.IMainPageFragmentProvider
import ru.iandreyshev.featureMenuApi.navigation.IMenuNavigator
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

    abstract fun inject(activity: MenuActivity)

    @Component(
            dependencies = [
                IMenuNavigator::class,
                IMainPageFragmentProvider::class]
    )
    interface DependenciesComponent : IFeatureMenuDependencies

}
