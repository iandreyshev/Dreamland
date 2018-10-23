package ru.iandreyshev.featureAccount.repository.remote

internal data class AccountGson(
        var id: Long = 0,
        var fullName: String = "",
        var avatarUrl: String = ""
)
