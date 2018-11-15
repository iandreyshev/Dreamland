package ru.iandreyshev.featureAccountApi.useCase

import io.reactivex.Completable

interface ILogoutUseCase {
    operator fun invoke(): Completable
}
