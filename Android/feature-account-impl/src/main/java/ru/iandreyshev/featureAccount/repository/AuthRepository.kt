package ru.iandreyshev.featureAccount.repository

import io.reactivex.Observable
import io.reactivex.Single
import ru.iandreyshev.featureAccountApi.data.*
import ru.iandreyshev.coreAndroid.rx.ioToMain

class AuthRepository : IAuthRepository {

    override val authStateObservable: Observable<Boolean>
        get() = Observable.create<Boolean> {
            it.onNext(false)
            it.onComplete()
        }

    override fun signIn(signInProperties: SignInProperties): Single<SignInResult> {
        return Single.fromCallable {
            Thread.sleep(500)
            SignInResult.SUCCESS
        }.ioToMain()
    }

    override fun signUp(signUpProperties: SignUpProperties): Single<SignUpResult> {
        return Single.fromCallable {
            Thread.sleep(500)
            SignUpResult.NO_CONNECTION
        }.ioToMain()
    }

}