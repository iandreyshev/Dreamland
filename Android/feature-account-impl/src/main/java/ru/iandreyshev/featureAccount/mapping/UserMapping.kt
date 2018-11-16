package ru.iandreyshev.featureAccount.mapping

import ru.iandreyshev.featureAccount.database.UserDatabaseEntity
import ru.iandreyshev.featureAccountApi.data.User

fun UserDatabaseEntity.toUser() =
        User(
                login = login,
                fullName = fullName,
                avatarUrl = avatarUrl
        )