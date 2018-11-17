package ru.iandreyshev.featureAccountApi.useCase

import io.reactivex.Single
import ru.iandreyshev.featureAccountApi.data.DeleteUserResult

interface IDeleteUserUseCase {
    operator fun invoke(): Single<DeleteUserResult>
}
