package ru.iandreyshev.featureDreams.di

import dagger.Component
import ru.iandreyshev.coreAndroid.di.context.IContextProvider
import ru.iandreyshev.coreAndroid.di.scope.PerFeature
import ru.iandreyshev.coreAndroid.ui.activity.BaseAppCompatActivity
import ru.iandreyshev.coreAndroid.ui.fragment.BaseFragment
import ru.iandreyshev.coreNetworkApi.api.ICoreNetworkApi
import ru.iandreyshev.featureAccountApi.api.IFeatureAccountApi
import ru.iandreyshev.featureDreams.di.dependencies.IFeatureDreamsDependencies
import ru.iandreyshev.featureDreams.ui.activity.DreamActivity
import ru.iandreyshev.featureDreams.ui.activity.DreamEditorActivity
import ru.iandreyshev.featureDreams.viewModel.DreamEditorViewModel
import ru.iandreyshev.featureDreams.viewModel.DreamListViewModel
import ru.iandreyshev.featureDreamsApi.api.IFeatureDreamsApi

@Component(
        modules = [
            FeatureDreamsModule::class,
            FeatureDreamsBindsModule::class,
            FeatureDreamsViewModelModule::class,
            FeatureDreamsUseCaseModule::class],
        dependencies = [
            IFeatureDreamsDependencies::class]
)
@PerFeature
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
    abstract fun inject(activity: DreamActivity)
    abstract fun inject(activity: DreamEditorActivity)
    abstract fun inject(fragment: BaseFragment)
    abstract fun inject(viewModel: DreamEditorViewModel)
    abstract fun inject(viewModel: DreamListViewModel)

    @Component(dependencies = [
        IContextProvider::class,
        ICoreNetworkApi::class,
        IFeatureAccountApi::class]
    )
    abstract class DependenciesComponent : IFeatureDreamsDependencies

}
