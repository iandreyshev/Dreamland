package ru.iandreyshev.featureAccount.repository

import io.reactivex.Observable

interface IUserRepository {

    fun getUser(): Observable<IUser>
    fun getUserAuthState(): Observable<Boolean>
    fun refresh()

}
