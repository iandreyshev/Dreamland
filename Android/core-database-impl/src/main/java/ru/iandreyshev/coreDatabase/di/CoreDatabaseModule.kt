package ru.iandreyshev.coreDatabase.di

import dagger.Module
import dagger.Provides
import io.objectbox.BoxStore
import ru.iandreyshev.coreDatabase.di.dependencies.IContextProvider
import ru.iandreyshev.coreDatabase.entity.MyObjectBox
import javax.inject.Singleton

@Module
class CoreDatabaseModule {

    @Provides
    @Singleton
    fun provideObjectBox(contextProvider: IContextProvider): BoxStore =
            MyObjectBox.builder().androidContext(contextProvider.context).build()

}
