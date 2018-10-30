package ru.iandreyshev.coreDatabaseApi.entity

class AccountEntity(
        val accountId: Long = 0,
        val login: String = "",
        val password: String = "",
        val fullName: String = "",
        val avatarUrl: String = ""
)
