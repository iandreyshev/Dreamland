package ru.iandreyshev.featureAccountApi.useCase

import io.reactivex.Single
import ru.iandreyshev.featureAccountApi.data.SignInProperties
import ru.iandreyshev.featureAccountApi.data.SignInResult

interface ISignInUseCase {
    operator fun invoke(signInProperties: SignInProperties): Single<SignInResult>
}
