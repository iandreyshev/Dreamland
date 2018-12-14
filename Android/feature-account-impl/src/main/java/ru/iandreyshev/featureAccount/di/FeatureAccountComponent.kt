package ru.iandreyshev.featureAccount.di

import dagger.Component
import ru.iandreyshev.coreAndroid.di.context.IContextProvider
import ru.iandreyshev.coreAndroid.ui.activity.BaseAppCompatActivity
import ru.iandreyshev.coreNetworkApi.api.ICoreNetworkApi
import ru.iandreyshev.featureAccount.di.dependencies.IAccountNavigator
import ru.iandreyshev.coreAndroid.ui.fragment.BaseFragment
import ru.iandreyshev.featureAccount.di.dependencies.IFeatureAccountDependencies
import ru.iandreyshev.featureAccountApi.api.IFeatureAccountApi
import ru.iandreyshev.featureDreamsApi.api.IFeatureDreamsApi
import javax.inject.Singleton

@Component(
        modules = [
            FeatureAccountModule::class,
            FeatureAccountBindsModule::class,
            FeatureAccountUseCaseModule::class,
            FeatureAccountViewModelModule::class],
        dependencies = [
            IFeatureAccountDependencies::class]
)
@Singleton
abstract class FeatureAccountComponent : IFeatureAccountApi {

    companion object {
        fun init(component: FeatureAccountComponent) {
            sInstance = component
        }

        fun get() = sInstance

        @Volatile
        private lateinit var sInstance: FeatureAccountComponent
    }

    abstract fun inject(activity: BaseAppCompatActivity)
    abstract fun inject(fragment: BaseFragment)

    @Component(
            dependencies = [
                IContextProvider::class,
                IAccountNavigator::class,
                ICoreNetworkApi::class,
                IFeatureDreamsApi::class]
    )
    abstract class DependenciesComponent : IFeatureAccountDependencies

}
