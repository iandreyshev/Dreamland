package ru.iandreyshev.featureDreamsApi.api

interface IFeatureDreamsApi {
    val dreamsDiaryFragmentFactory: IDreamsDiaryFragmentFactory
    val dreamsRepository: IDreamsRepository
}
