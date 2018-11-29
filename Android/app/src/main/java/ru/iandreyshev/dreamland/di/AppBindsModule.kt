package ru.iandreyshev.dreamland.di

import android.app.Application
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjectionModule
import ru.iandreyshev.dreamland.application.DreamlandApplication
import javax.inject.Singleton

@Module(includes = [AndroidInjectionModule::class])
abstract class AppBindsModule {

    @Binds
    @Singleton
    abstract fun provideContext(application: DreamlandApplication): Application

}
