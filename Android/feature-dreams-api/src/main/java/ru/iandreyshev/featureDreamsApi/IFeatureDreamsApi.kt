package ru.iandreyshev.featureDreamsApi

interface IFeatureDreamsApi {
    val dreamsDiaryFragmentFactory: IDreamsDiaryFragmentFactory
    val dreamsRepository: IDreamsRepository
}
