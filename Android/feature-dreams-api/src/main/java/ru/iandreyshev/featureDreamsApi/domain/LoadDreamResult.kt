package ru.iandreyshev.featureDreamsApi.domain

sealed class LoadDreamResult
class LoadingDreamCompleted(val properties: DreamProperties) : LoadDreamResult()
class UpdateDreamCompleted(val properties: DreamProperties) : LoadDreamResult()
object ErrorDreamDeleted : LoadDreamResult()