package ru.iandreyshev.featureAccount.model.storage

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import io.objectbox.annotation.Unique
import ru.iandreyshev.featureAccount.model.repository.Account
import ru.iandreyshev.featureAccount.model.repository.IAccount

@Entity
internal data class AccountEntity(
        @Id var id: Long = 0,
        @Unique var accountId: Long = 0,
        var login: String = "",
        var password: String = "",
        var fullName: String = "",
        var avatarUrl: String = ""
) {

    fun toAccount(): IAccount = Account(this)

}
