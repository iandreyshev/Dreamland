package ru.iandreyshev.featureDreams.useCase

import io.reactivex.Single
import ru.iandreyshev.featureDreams.domain.DeleteDreamResult
import ru.iandreyshev.featureDreamsApi.data.DreamIdentifier

interface IDeleteDreamUseCase {
    operator fun invoke(identifier: DreamIdentifier): Single<DeleteDreamResult>
}