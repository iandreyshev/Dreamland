package ru.iandreyshev.featureAccount.model.repository

import io.reactivex.Completable
import io.reactivex.SingleObserver

interface IUserRepository {

    fun getUser(observer: SingleObserver<IUser>)

    fun signIn(loginData: IAuthProperties, observer: SingleObserver<IAccount>)
    fun signOut(): Completable

    companion object {
        fun builder() = Builder()
    }

}
