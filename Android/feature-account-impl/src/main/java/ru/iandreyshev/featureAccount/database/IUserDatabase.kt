package ru.iandreyshev.featureAccount.database

import io.reactivex.Observable

interface IUserDatabase {
    val user: UserDatabaseEntity?
    val userObservable: Observable<UserDatabaseEntity>
    val isUserExists: Boolean
    fun saveUser(user: UserDatabaseEntity)
    fun clear()
}
