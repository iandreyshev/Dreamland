package ru.iandreyshev.featureDreams.useCase

import io.reactivex.Single
import ru.iandreyshev.featureDreams.domain.FetchDreamsResult

interface IFetchDreamsUseCase {
    operator fun invoke(): Single<FetchDreamsResult>
}
