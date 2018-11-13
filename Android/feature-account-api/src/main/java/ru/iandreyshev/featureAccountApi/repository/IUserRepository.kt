package ru.iandreyshev.featureAccountApi.repository

import io.reactivex.Observable

interface IUserRepository {

    fun getUserObservable(): Observable<IUser>
    fun getUserAuthStateObservable(): Observable<Boolean>
    fun refreshUserData()

}
