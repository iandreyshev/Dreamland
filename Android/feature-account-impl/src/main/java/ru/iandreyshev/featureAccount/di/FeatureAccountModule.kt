package ru.iandreyshev.featureAccount.di

import dagger.Module
import dagger.Provides
import io.objectbox.Box
import ru.iandreyshev.featureAccount.database.MyObjectBox
import ru.iandreyshev.featureAccount.database.UserDatabaseEntity
import ru.iandreyshev.featureAccount.di.dependencies.IContextProvider
import javax.inject.Singleton

@Module
class FeatureAccountModule {

    @Provides
    @Singleton
    fun provideUserBox(contextProvider: IContextProvider): Box<UserDatabaseEntity> =
            MyObjectBox.builder()
                    .androidContext(contextProvider.applicationContext)
                    .build()
                    .boxFor(UserDatabaseEntity::class.java)

}
