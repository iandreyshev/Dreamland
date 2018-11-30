package ru.iandreyshev.featureDreams.useCase

import io.reactivex.Single
import ru.iandreyshev.featureDreams.domain.DeleteDreamResult
import ru.iandreyshev.featureDreamsApi.data.DreamKey

interface IDeleteDreamUseCase {
    operator fun invoke(key: DreamKey): Single<DeleteDreamResult>
}