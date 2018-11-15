package ru.iandreyshev.featureAccountApi.useCase

import io.reactivex.Single
import ru.iandreyshev.featureAccountApi.data.SignUpProperties
import ru.iandreyshev.featureAccountApi.data.SignUpResult

interface ISignUpUseCase {
    operator fun invoke(signUpProperties: SignUpProperties): Single<SignUpResult>
}
