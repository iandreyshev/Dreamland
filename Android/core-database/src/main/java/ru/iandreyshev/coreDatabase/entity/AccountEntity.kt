package ru.iandreyshev.coreDatabase.entity

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Unique

@Entity
data class AccountEntity(
        @Id var id: Long = 0,
        @Unique var accountId: Long = 0,
        var login: String = "",
        var password: String = "",
        var fullName: String = "",
        var avatarUrl: String = ""
)
