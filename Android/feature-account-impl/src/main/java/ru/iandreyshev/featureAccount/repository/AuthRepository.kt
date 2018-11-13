package ru.iandreyshev.featureAccount.repository

import io.reactivex.Single
import ru.iandreyshev.featureAccountApi.repository.*
import ru.iandreyshev.rx.ioToMain

class AuthRepository : IAuthRepository {

    override fun signIn(signInProperties: ISignInProperties): Single<SignInResult> {
        return Single.fromCallable {
            Thread.sleep(250)
            SignInResult.SUCCESS
        }.ioToMain()
    }

    override fun signUp(signUpProperties: ISignUpProperties): Single<SignUpResult> {
        return Single.fromCallable {
            Thread.sleep(250)
            SignUpResult.NO_CONNECTION
        }.ioToMain()
    }

}