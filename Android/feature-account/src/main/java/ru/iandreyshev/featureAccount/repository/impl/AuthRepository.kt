package ru.iandreyshev.featureAccount.repository.impl

import io.reactivex.Single
import ru.iandreyshev.featureAccount.repository.IAuthRepository
import ru.iandreyshev.featureAccount.repository.ISignInProperties
import ru.iandreyshev.featureAccount.repository.ISignUpProperties
import ru.iandreyshev.rx.ioToMain

class AuthRepository : IAuthRepository {

    override fun signIn(signInProperties: ISignInProperties): Single<SignInResult> {
        return Single.fromCallable {
            Thread.sleep(3000)
            SignInResult.ERROR
        }.ioToMain()
    }

    override fun signUp(signUpProperties: ISignUpProperties): Single<SignUpResult> {
        return Single.fromCallable {
            Thread.sleep(3000)
            SignUpResult.ERROR
        }.ioToMain()
    }

}