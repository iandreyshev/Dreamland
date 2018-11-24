package ru.iandreyshev.featureDreams.di

import dagger.Binds
import dagger.Module
import ru.iandreyshev.featureDreams.useCase.impl.DeleteDreamUseCase
import ru.iandreyshev.featureDreams.useCase.impl.EditDreamUseCase
import ru.iandreyshev.featureDreams.useCase.impl.SaveDraftUseCase
import ru.iandreyshev.featureDreams.useCase.ISaveDreamUseCase
import ru.iandreyshev.featureDreams.useCase.impl.SaveDreamUseCase
import ru.iandreyshev.featureDreams.useCase.IDeleteDreamUseCase
import ru.iandreyshev.featureDreams.useCase.IEditDreamUseCase
import ru.iandreyshev.featureDreams.useCase.ISaveDraftUseCase
import javax.inject.Singleton

@Module
abstract class FeatureDreamsUseCaseModule {

    @Binds
    @Singleton
    abstract fun bindSaveDreamUseCase(useCase: SaveDreamUseCase): ISaveDreamUseCase

    @Binds
    @Singleton
    abstract fun bindSaveDraftUseCase(useCase: SaveDraftUseCase): ISaveDraftUseCase

    @Binds
    @Singleton
    abstract fun bindEditDreamUseCase(useCase: EditDreamUseCase): IEditDreamUseCase

    @Binds
    @Singleton
    abstract fun bindDeleteDreamUseCase(useCase: DeleteDreamUseCase): IDeleteDreamUseCase

}
