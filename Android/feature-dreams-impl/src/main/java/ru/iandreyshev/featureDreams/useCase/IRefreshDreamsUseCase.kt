package ru.iandreyshev.featureDreams.useCase

import io.reactivex.Single
import ru.iandreyshev.featureDreams.domain.RefreshDreamsResult

interface IRefreshDreamsUseCase {
    operator fun invoke(): Single<RefreshDreamsResult>
}
