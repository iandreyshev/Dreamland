package ru.iandreyshev.featureAccount.storage

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Unique

@Entity
data class UserStorageEntity(
        @Id var id: Long = 0,
        @Unique var accountId: Long = 0,
        var password: String = "",
        var login: String = "",
        var fullName: String = "",
        var avatarUrl: String = ""
)
