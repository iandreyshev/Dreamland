package ru.iandreyshev.featureMenu.di

import dagger.Binds
import dagger.Module
import ru.iandreyshev.featureMenu.useCase.IStartupUseCase
import ru.iandreyshev.featureMenu.useCase.StartupUseCase

@Module
abstract class FeatureMenuUseCaseModule {
    @Binds
    abstract fun bindStartupUseCase(useCase: StartupUseCase): IStartupUseCase
}