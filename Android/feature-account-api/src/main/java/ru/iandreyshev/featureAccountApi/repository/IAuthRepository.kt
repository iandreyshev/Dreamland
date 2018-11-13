package ru.iandreyshev.featureAccountApi.repository

import io.reactivex.Single

interface IAuthRepository {

    fun signIn(signInProperties: ISignInProperties): Single<SignInResult>
    fun signUp(signUpProperties: ISignUpProperties): Single<SignUpResult>

}
