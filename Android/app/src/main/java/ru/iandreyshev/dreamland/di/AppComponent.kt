package ru.iandreyshev.dreamland.di

import dagger.Component
import ru.iandreyshev.coreAndroid.ui.activity.BaseAppCompatActivity
import ru.iandreyshev.dreamland.application.DreamlandApplication
import ru.iandreyshev.featureAccount.di.FeatureAccountViewModelModule
import ru.iandreyshev.featureDreams.di.FeatureDreamsViewModelModule
import ru.iandreyshev.featureMenu.di.FeatureMenuViewModelModule
import javax.inject.Singleton

@Component(
        modules = [
            AppModule::class,
            AppViewModelModule::class,
            AppNavigationModule::class,
            FeatureMenuViewModelModule::class,
            FeatureDreamsViewModelModule::class,
            FeatureAccountViewModelModule::class]
)
@Singleton
abstract class AppComponent {

    companion object {
        fun init(component: AppComponent) {
            sInstance = component
        }

        fun get() = sInstance

        @Volatile
        private lateinit var sInstance: AppComponent
    }

    abstract fun inject(application: DreamlandApplication)
    abstract fun inject(activity: BaseAppCompatActivity)

}
