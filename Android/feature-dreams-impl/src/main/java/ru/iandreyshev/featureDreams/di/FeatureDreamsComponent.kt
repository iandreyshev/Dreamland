package ru.iandreyshev.featureDreams.di

import dagger.Component
import ru.iandreyshev.coreAndroid.ui.activity.BaseAppCompatActivity
import ru.iandreyshev.coreAndroid.ui.fragment.BaseFragment
import ru.iandreyshev.featureDreams.di.dependencies.IFeatureDreamsDependencies
import ru.iandreyshev.featureDreams.viewModel.EditDreamViewModel
import ru.iandreyshev.featureDreams.viewModel.DreamListViewModel
import ru.iandreyshev.featureDreamsApi.api.IFeatureDreamsApi
import javax.inject.Singleton

@Component(
        modules = [
            FeatureDreamsSharedModule::class,
            FeatureDreamsSharedBindsModule::class,
            FeatureDreamsViewModelModule::class,
            FeatureDreamsUseCaseModule::class],
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
    abstract fun inject(viewModel: EditDreamViewModel)
    abstract fun inject(viewModel: DreamListViewModel)

    @Component
    abstract class DependenciesComponent : IFeatureDreamsDependencies

}
