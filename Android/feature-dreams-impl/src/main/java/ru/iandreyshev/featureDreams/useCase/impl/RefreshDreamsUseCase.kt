package ru.iandreyshev.featureDreams.useCase.impl

import io.reactivex.Single
import ru.iandreyshev.featureDreams.useCase.IRefreshDreamsUseCase
import ru.iandreyshev.featureDreams.domain.RefreshDreamsResult
import javax.inject.Inject

class RefreshDreamsUseCase
@Inject constructor() : IRefreshDreamsUseCase {

    override fun invoke(): Single<RefreshDreamsResult> =
            Single.just(RefreshDreamsResult.SUCCESS)

}