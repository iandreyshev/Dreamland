package ru.iandreyshev.featureAccountApi.useCase

import io.reactivex.Completable

interface ILogOutUseCase {
    operator fun invoke(): Completable
}
