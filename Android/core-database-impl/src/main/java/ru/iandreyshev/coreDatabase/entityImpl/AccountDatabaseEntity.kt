package ru.iandreyshev.coreDatabase.entityImpl

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Unique
import ru.iandreyshev.coreDatabaseApi.account.AccountEntity

@Entity
internal data class AccountDatabaseEntity(
        @Id var id: Long = 0,
        @Unique var accountId: Long = 0,
        var login: String = "",
        var password: String = "",
        var fullName: String = "",
        var avatarUrl: String = ""
)

internal fun AccountDatabaseEntity.toApiEntity() =
        AccountEntity(
                accountId = accountId,
                login = login,
                password = password,
                fullName = fullName,
                avatarUrl = avatarUrl
        )

internal fun AccountEntity.toDatabaseEntity() =
        AccountDatabaseEntity(
                accountId = accountId,
                login = login,
                password = password,
                fullName = fullName,
                avatarUrl = avatarUrl
        )
