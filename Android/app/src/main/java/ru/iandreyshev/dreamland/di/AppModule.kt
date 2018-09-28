package ru.iandreyshev.dreamland.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.iandreyshev.dreamland.application.DreamlandApplication
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    internal fun provideContext(): Context =
            DreamlandApplication.appContext

}
