package ru.iandreyshev.featureDreams.di

import dagger.Binds
import dagger.Module
import ru.iandreyshev.featureDreams.useCase.*
import ru.iandreyshev.featureDreams.useCase.impl.*
import javax.inject.Singleton

@Module
abstract class FeatureDreamsUseCaseModule {

    @Binds
    @Singleton
    abstract fun bindSaveDreamUseCase(useCase: SaveDreamUseCase): ISaveDreamUseCase

    @Binds
    @Singleton
    abstract fun bindDeleteDreamUseCase(useCase: DeleteDreamUseCase): IDeleteDreamUseCase

    @Binds
    @Singleton
    abstract fun bindRefreshDreansUseCase(useCase: FetchDreamsUseCase): IFetchDreamsUseCase

}
