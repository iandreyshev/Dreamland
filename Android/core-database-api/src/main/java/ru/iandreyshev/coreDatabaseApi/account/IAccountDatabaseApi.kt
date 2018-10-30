package ru.iandreyshev.coreDatabaseApi.account

import io.reactivex.Observable

interface IAccountDatabaseApi {
    val userObservable: Observable<AccountEntity>
}
