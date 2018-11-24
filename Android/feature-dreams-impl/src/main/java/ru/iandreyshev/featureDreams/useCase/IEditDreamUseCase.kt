package ru.iandreyshev.featureDreams.useCase

import io.reactivex.Single
import ru.iandreyshev.featureDreamsApi.data.DreamIdentifier
import ru.iandreyshev.featureDreams.domain.DreamProperties
import ru.iandreyshev.featureDreams.domain.EditDreamResult

interface IEditDreamUseCase {
    operator fun invoke(identifier: DreamIdentifier, dream: DreamProperties): Single<EditDreamResult>
}
