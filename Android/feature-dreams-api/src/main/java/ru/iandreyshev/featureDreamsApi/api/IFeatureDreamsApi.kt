package ru.iandreyshev.featureDreamsApi.api

import ru.iandreyshev.featureDreamsApi.useCase.IClearDreamsStorageUseCase

interface IFeatureDreamsApi {
    val dreamsRepository: IDreamsRepository
    val dreamsDiaryFragmentFactory: IDreamsDiaryFragmentFactory
    val clearStorageUseCase: IClearDreamsStorageUseCase
}
