package ru.iandreyshev.featureMenu.model

import ru.iandreyshev.coreDatabase.entity.AccountEntity

data class User(
        val fullName: String,
        val avatarUrl: String
) {

    constructor(accountEntity: AccountEntity) : this(
            fullName = accountEntity.fullName,
            avatarUrl = accountEntity.avatarUrl)

}
