package ru.iandreyshev.featureAccountApi.useCase

import io.reactivex.Single

interface IGetAuthStateUseCase {
    operator fun invoke(): Single<Boolean>
}
