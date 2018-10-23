package ru.iandreyshev.featureAccount.repository

import io.reactivex.Single
import ru.iandreyshev.featureAccount.repository.impl.SignInResult
import ru.iandreyshev.featureAccount.repository.impl.SignUpResult

interface IAuthRepository {

    fun signIn(signInProperties: ISignInProperties): Single<SignInResult>
    fun signUp(signUpProperties: ISignUpProperties): Single<SignUpResult>

}
