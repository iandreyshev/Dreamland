package ru.iandreyshev.featureDreams.useCase

import io.reactivex.Single
import ru.iandreyshev.featureDreams.domain.RefreshDreamsResult

interface IFetchDreamsUseCase {
    operator fun invoke(): Single<RefreshDreamsResult>
}
