package ru.iandreyshev.featureAccount.useCase

import io.reactivex.Completable

interface IRefreshUserUseCase {
    fun refresh(): Completable
}
