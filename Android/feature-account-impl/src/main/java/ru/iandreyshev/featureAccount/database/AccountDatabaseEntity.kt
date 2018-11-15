package ru.iandreyshev.featureAccount.database

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Unique

@Entity
data class AccountDatabaseEntity(
        @Id var id: Long = 0,
        @Unique var accountId: Long = 0,
        var login: String = "",
        var password: String = "",
        var fullName: String = "",
        var avatarUrl: String = ""
)
