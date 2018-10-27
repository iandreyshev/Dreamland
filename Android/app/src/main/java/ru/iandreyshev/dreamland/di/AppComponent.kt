package ru.iandreyshev.dreamland.di

import dagger.Component
import ru.iandreyshev.activity.BaseAppCompatActivity
import ru.iandreyshev.dreamland.application.DreamlandApplication
import ru.iandreyshev.featureAccount.di.FeatureAccountModule
import javax.inject.Singleton

@Component(
        modules = [
            AppModule::class,
            AppViewModelModule::class,
            AppNavigationModule::class,
            FeatureAccountModule::class]
)
@Singleton
abstract class AppComponent {

    abstract fun inject(application: DreamlandApplication)
    abstract fun inject(activity: BaseAppCompatActivity)

    companion object {
        fun init(component: AppComponent) {
            sInstance = component
        }

        fun get() = sInstance

        @Volatile
        private lateinit var sInstance: AppComponent
    }

}
