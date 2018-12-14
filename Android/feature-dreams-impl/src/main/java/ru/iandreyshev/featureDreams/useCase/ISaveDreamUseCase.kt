package ru.iandreyshev.featureDreams.useCase

import io.reactivex.Single
import ru.iandreyshev.featureDreamsApi.domain.DreamKey
import ru.iandreyshev.featureDreamsApi.domain.DreamProperties
import ru.iandreyshev.featureDreams.domain.SaveDreamResult

interface ISaveDreamUseCase {
    operator fun invoke(dream: DreamProperties, key: DreamKey? = null): Single<SaveDreamResult>
}
