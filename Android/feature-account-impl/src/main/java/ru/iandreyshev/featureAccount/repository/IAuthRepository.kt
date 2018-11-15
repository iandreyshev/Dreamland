package ru.iandreyshev.featureAccount.repository

import io.reactivex.Observable
import io.reactivex.Single
import ru.iandreyshev.featureAccountApi.data.SignInProperties
import ru.iandreyshev.featureAccountApi.data.SignInResult
import ru.iandreyshev.featureAccountApi.data.SignUpProperties
import ru.iandreyshev.featureAccountApi.data.SignUpResult

interface IAuthRepository {
    val authStateObservable: Observable<Boolean>
    fun signIn(signInProperties: SignInProperties): Single<SignInResult>
    fun signUp(signUpProperties: SignUpProperties): Single<SignUpResult>
}
