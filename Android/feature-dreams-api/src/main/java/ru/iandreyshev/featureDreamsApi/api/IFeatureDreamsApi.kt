package ru.iandreyshev.featureDreamsApi.api

interface IFeatureDreamsApi {
    val dreamsRepository: IDreamsRepository
    val dreamsDiaryFragmentFactory: IDreamsDiaryFragmentFactory
}
