package ru.iandreyshev.dreamland.di

import android.content.Context
import dagger.Module
import dagger.Provides
import io.objectbox.BoxStore
import ru.iandreyshev.coreDatabase.entity.MyObjectBox
import ru.iandreyshev.dreamland.application.DreamlandApplication
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    internal fun provideContext(): Context =
            DreamlandApplication.instance.applicationContext

    @Singleton
    @Provides
    internal fun provideObjectBox(): BoxStore =
            MyObjectBox.builder()
                    .androidContext(DreamlandApplication.instance.applicationContext)
                    .build()

}
