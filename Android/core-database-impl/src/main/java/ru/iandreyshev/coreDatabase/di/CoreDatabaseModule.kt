package ru.iandreyshev.coreDatabase.di

import android.content.Context
import dagger.Module
import dagger.Provides
import io.objectbox.Box
import io.objectbox.BoxStore
import ru.iandreyshev.coreDatabase.entityImpl.AccountDatabaseEntity
import ru.iandreyshev.coreDatabase.entityImpl.MyObjectBox
import javax.inject.Named
import javax.inject.Singleton

@Module
internal class CoreDatabaseModule {

    @Provides
    @Singleton
    internal fun provideObjectBox(context: Context): BoxStore =
            MyObjectBox.builder()
                    .androidContext(context)
                    .build()

    @Provides
    @Singleton
    internal fun provideUserBox(boxStore: BoxStore): Box<AccountDatabaseEntity> =
            boxStore.boxFor(AccountDatabaseEntity::class.java)

}
