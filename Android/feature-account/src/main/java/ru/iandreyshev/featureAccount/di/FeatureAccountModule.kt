package ru.iandreyshev.featureAccount.di

import android.arch.lifecycle.LiveData
import dagger.Module
import dagger.Provides
import ru.iandreyshev.featureAccount.repository.*
import ru.iandreyshev.rx.ioToMain
import ru.iandreyshev.vext.liveData.mutableLiveDataOf
import javax.inject.Singleton

@Module
class FeatureAccountModule {

    @Provides
    @Singleton
    internal fun provideUserRepository(): IUserRepository =
            UserRepository()

    @Provides
    @Singleton
    internal fun provideAuthRepository(): IAuthRepository =
            AuthRepository()

    @Provides
    internal fun provideAccountObservable(repository: IUserRepository): LiveData<IUser> {
        val liveData = mutableLiveDataOf<IUser>()
        repository.getUser()
                .ioToMain()
                .subscribe(liveData::setValue)
        return liveData
    }

}
