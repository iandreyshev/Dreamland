package ru.iandreyshev.featureMenu.di

import android.arch.lifecycle.LiveData
import dagger.Module
import dagger.Provides
import ru.iandreyshev.featureMenu.di.dependencies.IFeatureMenuDependencies
import ru.iandreyshev.featureMenu.model.User

@Module
internal class FeatureMenuModule {

    @Provides
    fun provideUserObservable(dependencies: IFeatureMenuDependencies): LiveData<User> {
        return TODO()
    }

}
