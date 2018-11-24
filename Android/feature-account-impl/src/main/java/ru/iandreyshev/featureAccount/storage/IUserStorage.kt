package ru.iandreyshev.featureAccount.storage

import io.reactivex.Observable

interface IUserStorage {
    val user: UserStorageEntity?
    val userObservable: Observable<UserStorageEntity>
    val isUserExists: Boolean
    fun saveUser(user: UserStorageEntity)
    fun clear()
}
