package ru.iandreyshev.featureAccount.repository

import ru.iandreyshev.coreDatabaseApi.account.AccountEntity
import ru.iandreyshev.featureAccountApi.repository.IUser

data class User(
        override val login: String,
        override val password: String,
        override val fullName: String,
        override val avatarUrl: String
) : IUser {

    constructor(entity: AccountEntity)
            : this(entity.login, entity.password, entity.fullName, entity.avatarUrl)

}