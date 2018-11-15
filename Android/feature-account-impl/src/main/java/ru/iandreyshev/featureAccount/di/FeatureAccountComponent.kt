package ru.iandreyshev.featureAccount.di

import android.arch.lifecycle.ViewModelProvider
import dagger.Component
import ru.iandreyshev.coreAndroid.ui.activity.BaseAppCompatActivity
import ru.iandreyshev.coreNetworkApi.ICoreNetworkApi
import ru.iandreyshev.featureAccount.di.dependencies.IAccountNavigator
import ru.iandreyshev.coreAndroid.ui.fragment.BaseFragment
import ru.iandreyshev.featureAccount.di.dependencies.IFeatureAccountDependencies
import ru.iandreyshev.featureAccount.useCase.LogoutUseCase
import ru.iandreyshev.featureAccount.viewModel.AuthViewModel
import ru.iandreyshev.featureAccount.viewModel.SignInViewModel
import ru.iandreyshev.featureAccount.viewModel.SignUpViewModel
import ru.iandreyshev.featureAccountApi.api.IFeatureAccountApi
import javax.inject.Singleton

@Component(
        modules = [
            FeatureAccountModule::class,
            FeatureAccountViewModelModule::class,
            FeatureAccountUseCaseModule::class],
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
    abstract fun inject(viewModel: SignInViewModel)
    abstract fun inject(viewModel: SignUpViewModel)
    abstract fun inject(viewModel: AuthViewModel)
    abstract fun inject(useCase: LogoutUseCase)

    @Component(
            dependencies = [
                ViewModelProvider.Factory::class,
                IAccountNavigator::class,
                ICoreNetworkApi::class]
    )
    abstract class DependenciesComponent : IFeatureAccountDependencies

}
