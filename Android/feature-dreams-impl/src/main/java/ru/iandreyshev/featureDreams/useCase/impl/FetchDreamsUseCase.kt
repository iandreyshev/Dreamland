package ru.iandreyshev.featureDreams.useCase.impl

import io.reactivex.Single
import ru.iandreyshev.featureDreams.useCase.IFetchDreamsUseCase
import ru.iandreyshev.featureDreams.domain.RefreshDreamsResult
import javax.inject.Inject

class FetchDreamsUseCase
@Inject constructor() : IFetchDreamsUseCase {

    override fun invoke(): Single<RefreshDreamsResult> =
            Single.just(RefreshDreamsResult.SUCCESS)

}