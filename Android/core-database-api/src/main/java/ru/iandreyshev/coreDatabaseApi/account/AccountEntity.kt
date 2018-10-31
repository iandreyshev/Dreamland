package ru.iandreyshev.coreDatabaseApi.account


class AccountEntity(
        val accountId: Long = 0,
        val login: String = "",
        val password: String = "",
        val fullName: String = "",
        val avatarUrl: String = ""
)
