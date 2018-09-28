package ru.iandreyshev.dreamland.di

import dagger.Component
import ru.iandreyshev.dreamland.application.DreamlandApplication
import javax.inject.Singleton

@Component(
        modules = [AppModule::class]
)
@Singleton
abstract class AppComponent {

    abstract fun inject(application: DreamlandApplication)

    companion object {
        fun init(component: AppComponent) {
            instance = component
        }

        fun get() = instance

        @Volatile
        private lateinit var instance: AppComponent
    }

}
