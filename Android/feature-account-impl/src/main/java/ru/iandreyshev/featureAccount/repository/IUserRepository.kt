package ru.iandreyshev.featureAccount.repository

import io.reactivex.Completable
import io.reactivex.Observable
import ru.iandreyshev.featureAccountApi.data.User

interface IUserRepository {
    val userObservable: Observable<User>
    fun logout(): Completable
}
