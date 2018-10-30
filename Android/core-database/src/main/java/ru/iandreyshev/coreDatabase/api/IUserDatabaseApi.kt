package ru.iandreyshev.coreDatabase.api

import io.reactivex.Observable
import ru.iandreyshev.coreDatabase.entity.AccountEntity

interface IUserDatabaseApi {
    val userObservable: Observable<AccountEntity>
}
