package ru.iandreyshev.featureMenu.useCase

import io.reactivex.Single

interface IStartupUseCase {
    operator fun invoke(): Single<Boolean>
}
