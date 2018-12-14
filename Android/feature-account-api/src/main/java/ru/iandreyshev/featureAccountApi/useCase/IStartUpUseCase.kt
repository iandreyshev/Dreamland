package ru.iandreyshev.featureAccountApi.useCase

import io.reactivex.Single

interface IStartUpUseCase {
    operator fun invoke(): Single<Boolean>
}
