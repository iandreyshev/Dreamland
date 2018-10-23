package ru.iandreyshev.featureAccount.repository

import io.reactivex.Observable
import ru.iandreyshev.featureAccount.repository.impl.AuthState

interface IUserRepository {

    fun getUser(): Observable<IUser>
    fun getUserAuthState(): Observable<AuthState>

}
