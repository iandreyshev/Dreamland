package ru.iandreyshev.dreams.di

import android.arch.lifecycle.ViewModel
import dagger.Component
import ru.iandreyshev.activity.BaseAppCompatActivity
import ru.iandreyshev.dreams.presentation.BaseFragment
import javax.inject.Singleton

@Component(
        modules = [FeatureDreamsViewModelModule::class],
        dependencies = [IFeatureDreamsDependencies::class]
)
@Singleton
abstract class FeatureDreamsComponent {

    companion object {
        fun init(component: FeatureDreamsComponent) {
            sInstance = component
        }

        fun get() = sInstance

        @Volatile
        private lateinit var sInstance: FeatureDreamsComponent
    }

    abstract fun inject(activity: BaseAppCompatActivity)
    abstract fun inject(fragment: BaseFragment)
    abstract fun inject(viewModel: ViewModel)

    @Component(
            dependencies = []
    )
    abstract class DependenciesComponent : IFeatureDreamsDependencies

}
