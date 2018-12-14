package ru.iandreyshev.featureDreamsApi.useCase

import io.reactivex.Completable

interface IClearDreamsStorageUseCase {
    operator fun invoke(): Completable
}
