package ru.iandreyshev.featureAccount.repository

import io.reactivex.Single
import ru.iandreyshev.rx.ioToMain

class AuthRepository : IAuthRepository {

    override fun signIn(signInProperties: ISignInProperties): Single<SignInResult> {
        return Single.fromCallable {
            Thread.sleep(3000)
            SignInResult.UNKNOWN
        }.ioToMain()
    }

    override fun signUp(signUpProperties: ISignUpProperties): Single<SignUpResult> {
        return Single.fromCallable {
            Thread.sleep(3000)
            SignUpResult.NO_CONNECTION
        }.ioToMain()
    }

}