package ru.iandreyshev.featureDreams.useCase

import io.reactivex.Completable
import ru.iandreyshev.featureDreams.domain.DreamProperties

interface ISaveDraftUseCase {
    operator fun invoke(draft: DreamProperties): Completable
}
