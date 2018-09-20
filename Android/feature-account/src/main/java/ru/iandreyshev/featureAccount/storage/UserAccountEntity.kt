package ru.iandreyshev.featureAccount.storage

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
internal data class UserAccountEntity(
        @Id var userId: Long
)
