package ru.iandreyshev.featureDreams.di

import android.arch.lifecycle.ViewModelProvider
import dagger.Component
import ru.iandreyshev.coreAndroid.ui.activity.BaseAppCompatActivity
import ru.iandreyshev.coreAndroid.ui.fragment.BaseFragment
import ru.iandreyshev.featureDreams.di.dependencies.IFeatureDreamsDependencies
import ru.iandreyshev.featureDreams.viewModel.DreamConstructorViewModel
import ru.iandreyshev.featureDreams.viewModel.DreamsDiaryViewModel
import ru.iandreyshev.featureDreamsApi.api.IFeatureDreamsApi
import javax.inject.Singleton

@Component(
        modules = [
            FeatureDreamsViewModelModule::class,
            FeatureDreamsModule::class],
        dependencies = [
            IFeatureDreamsDependencies::class]
)
@Singleton
abstract class FeatureDreamsComponent : IFeatureDreamsApi {

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
    abstract fun inject(viewModel: DreamConstructorViewModel)
    abstract fun inject(viewModel: DreamsDiaryViewModel)

    @Component(
            dependencies = [
                ViewModelProvider.Factory::class]
    )
    abstract class DependenciesComponent : IFeatureDreamsDependencies

}
