package ru.iandreyshev.featureDreams.di

import dagger.Binds
import dagger.Module
import ru.iandreyshev.featureDreams.repository.DreamsRepository
import ru.iandreyshev.featureDreamsApi.IDreamsRepository
import javax.inject.Singleton

@Module
abstract class FeatureDreamsBindsModule {

    @Binds
    @Singleton
    abstract fun bindDreamsRepository(repository: DreamsRepository): IDreamsRepository

}
