package ru.iandreyshev.featureDreams.useCase

import io.reactivex.Single
import ru.iandreyshev.featureDreamsApi.data.DreamIdentifier
import ru.iandreyshev.featureDreams.domain.DreamProperties
import ru.iandreyshev.featureDreams.domain.SaveDreamResult

interface ISaveDreamUseCase {
    operator fun invoke(dream: DreamProperties): Single<SaveDreamResult>
}
