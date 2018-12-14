package ru.iandreyshev.featureDreams.di

import dagger.Binds
import dagger.Module
import ru.iandreyshev.coreAndroid.di.scope.PerFeature
import ru.iandreyshev.featureDreams.useCase.*
import ru.iandreyshev.featureDreams.useCase.impl.*
import ru.iandreyshev.featureDreamsApi.useCase.IClearDreamsStorageUseCase
import javax.inject.Singleton

@Module
abstract class FeatureDreamsUseCaseModule {

    @Binds
    @PerFeature
    abstract fun bindSaveDreamUseCase(useCase: SaveDreamUseCase): ISaveDreamUseCase

    @Binds
    @PerFeature
    abstract fun bindDeleteDreamUseCase(useCase: DeleteDreamUseCase): IDeleteDreamUseCase

    @Binds
    @PerFeature
    abstract fun bindRefreshDreansUseCase(useCase: FetchDreamsUseCase): IFetchDreamsUseCase

    @Binds
    @PerFeature
    abstract fun bindClearDreamsStorageUseCase(useCase: ClearDreamsStorageUseCase): IClearDreamsStorageUseCase

}
