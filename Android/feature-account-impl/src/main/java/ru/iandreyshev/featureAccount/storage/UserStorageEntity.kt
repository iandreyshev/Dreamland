package ru.iandreyshev.featureAccount.storage

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Unique

@Entity
data class UserStorageEntity(
        @Id(assignable = true)
        var id: Long = 0,
        var password: String = "",
        var login: String = "",
        var fullName: String = "",
        var avatarUrl: String = ""
)
