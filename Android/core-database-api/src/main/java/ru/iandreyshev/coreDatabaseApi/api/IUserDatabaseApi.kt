package ru.iandreyshev.coreDatabaseApi.api

import io.reactivex.Observable
import ru.iandreyshev.coreDatabaseApi.entity.AccountEntity

interface IUserDatabaseApi {
    val userObservable: Observable<AccountEntity>
}
