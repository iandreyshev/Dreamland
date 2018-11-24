package ru.iandreyshev.featureAccount.di

import dagger.Module
import dagger.Provides
import io.objectbox.Box
import ru.iandreyshev.featureAccount.storage.MyObjectBox
import ru.iandreyshev.featureAccount.storage.UserStorageEntity
import ru.iandreyshev.featureAccount.di.dependencies.IContextProvider
import javax.inject.Singleton

@Module
class FeatureAccountModule {

    @Provides
    @Singleton
    fun provideUserBox(contextProvider: IContextProvider): Box<UserStorageEntity> =
            MyObjectBox.builder()
                    .androidContext(contextProvider.applicationContext)
                    .build()
                    .boxFor(UserStorageEntity::class.java)

}
