package ru.iandreyshev.dreamland.di

import dagger.Component
import dagger.android.AndroidInjector
import ru.iandreyshev.dreamland.application.DreamlandApplication
import javax.inject.Singleton

@Component(modules = [AppModule::class])
@Singleton
interface AppComponent : AndroidInjector<DreamlandApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<DreamlandApplication>()

}
