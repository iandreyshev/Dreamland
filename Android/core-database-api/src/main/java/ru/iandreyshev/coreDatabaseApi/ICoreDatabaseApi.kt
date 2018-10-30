package ru.iandreyshev.coreDatabaseApi

import ru.iandreyshev.coreDatabaseApi.account.IAccountDatabaseApi

interface ICoreDatabaseApi {
    val accountDatabaseApi: IAccountDatabaseApi
}