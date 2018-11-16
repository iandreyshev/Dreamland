package ru.iandreyshev.featureAccount.di

import dagger.Module
import dagger.Provides
import io.objectbox.Box
import io.reactivex.Observable
import ru.iandreyshev.featureAccountApi.data.User
import ru.iandreyshev.featureAccount.database.IUserDatabase
import ru.iandreyshev.featureAccount.database.MyObjectBox
import ru.iandreyshev.featureAccount.database.UserDatabase
import ru.iandreyshev.featureAccount.database.UserDatabaseEntity
import ru.iandreyshev.featureAccount.di.dependencies.IContextProvider
import ru.iandreyshev.featureAccount.network.IUserServer
import ru.iandreyshev.featureAccount.network.UserServer
import javax.inject.Singleton

@Module
class FeatureAccountModule {

    @Provides
    @Singleton
    fun provideAccountObservable(): Observable<User?> =
            Observable.create { }

    @Provides
    @Singleton
    fun provideUserBox(contextProvider: IContextProvider): Box<UserDatabaseEntity> =
            MyObjectBox.builder()
                    .androidContext(contextProvider.applicationContext)
                    .build()
                    .boxFor(UserDatabaseEntity::class.java)

}
