package ru.iandreyshev.featureAccount.di

import android.arch.lifecycle.ViewModel
import dagger.Component
import ru.iandreyshev.activity.BaseAppCompatActivity
import ru.iandreyshev.coreDatabaseApi.ICoreDatabaseApi
import ru.iandreyshev.coreNetworkApi.ICoreNetworkApi
import ru.iandreyshev.featureAccount.navigation.IAccountNavigator
import ru.iandreyshev.dreams.presentation.BaseFragment
import javax.inject.Singleton

@Component(
        modules = [
            FeatureAccountModule::class,
            FeatureAccountViewModelModule::class,
            FeatureAccountUseCaseModule::class],
        dependencies = [IFeatureAccountDependencies::class]
)
@Singleton
abstract class FeatureAccountComponent {

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
    abstract fun inject(viewModel: ViewModel)

    @Component(
            dependencies = [
                IAccountNavigator::class,
                ICoreNetworkApi::class,
                ICoreDatabaseApi::class]
    )
    abstract class DependenciesComponent : IFeatureAccountDependencies

}