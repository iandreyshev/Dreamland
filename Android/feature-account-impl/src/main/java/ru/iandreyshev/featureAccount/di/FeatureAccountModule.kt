package ru.iandreyshev.featureAccount.di

import dagger.Module
import dagger.Provides
import io.objectbox.Box
import io.objectbox.BoxStore
import io.objectbox.android.AndroidObjectBrowser
import ru.iandreyshev.coreAndroid.di.context.IContextProvider
import ru.iandreyshev.featureAccount.BuildConfig
import ru.iandreyshev.featureAccount.storage.MyObjectBox
import ru.iandreyshev.featureAccount.storage.UserStorageEntity
import javax.inject.Singleton

@Module
class FeatureAccountModule {

    @Provides
    @Singleton
    fun provideBoxStore(contextProvider: IContextProvider): BoxStore =
            MyObjectBox.builder()
                    .androidContext(contextProvider.context)
                    .name("FeatureAccount")
                    .build()

    @Provides
    @Singleton
    fun provideUserBox(boxStore: BoxStore): Box<UserStorageEntity> =
            boxStore.boxFor(UserStorageEntity::class.java)

}
