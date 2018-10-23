package ru.iandreyshev.featureAccount.di

import android.app.Application
import dagger.Component
import ru.iandreyshev.featureAccount.presentation.activity.AuthActivity
import ru.iandreyshev.featureAccount.presentation.fragment.SignInFragment
import ru.iandreyshev.featureAccount.presentation.fragment.SignUpFragment
import ru.iandreyshev.featureAccount.viewModel.AuthViewModel
import ru.iandreyshev.featureAccount.viewModel.SignInViewModel
import ru.iandreyshev.featureAccount.viewModel.SignUpViewModel
import javax.inject.Singleton

@Component(
        modules = [FeatureAccountModule::class, FeatureAccountViewModelModule::class],
        dependencies = [Application::class]
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

    abstract fun inject(activity: AuthActivity)
    abstract fun inject(fragment: SignInFragment)
    abstract fun inject(fragment: SignUpFragment)
    abstract fun inject(viewModel: AuthViewModel)
    abstract fun inject(viewModel: SignInViewModel)
    abstract fun inject(viewModel: SignUpViewModel)

}
