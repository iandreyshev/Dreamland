package ru.iandreyshev.coreDatabase.di

import android.content.Context
import dagger.Module
import dagger.Provides
import io.objectbox.BoxStore
import ru.iandreyshev.coreDatabase.entityImpl.MyObjectBox
import javax.inject.Singleton

@Module
internal class CoreDatabaseModule {

    @Singleton
    @Provides
    internal fun provideObjectBox(context: Context): BoxStore =
            MyObjectBox.builder()
                    .androidContext(context)
                    .build()

}