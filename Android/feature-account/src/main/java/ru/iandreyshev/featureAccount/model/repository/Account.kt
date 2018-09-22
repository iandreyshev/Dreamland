package ru.iandreyshev.featureAccount.model.repository

import ru.iandreyshev.featureAccount.model.storage.AccountEntity

internal data class Account(
        override val login: String,
        override val password: String,
        override val fullName: String,
        override val avatarUrl: String
) : IAccount {

    constructor(entity: AccountEntity)
            : this(entity.login, entity.password, entity.fullName, entity.avatarUrl)

}
