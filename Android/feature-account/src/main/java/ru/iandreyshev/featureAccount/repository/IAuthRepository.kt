package ru.iandreyshev.featureAccount.repository

import io.reactivex.Single

interface IAuthRepository {

    fun signIn(signInProperties: ISignInProperties): Single<SignInResult>
    fun signUp(signUpProperties: ISignUpProperties): Single<SignUpResult>

}
