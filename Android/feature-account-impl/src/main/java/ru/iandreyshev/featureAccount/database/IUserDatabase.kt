package ru.iandreyshev.featureAccount.database

import io.reactivex.Observable

interface IUserDatabase {
    val userObservable: Observable<UserDatabaseEntity>
    fun saveUser(user: UserDatabaseEntity)
    fun clear()
}
