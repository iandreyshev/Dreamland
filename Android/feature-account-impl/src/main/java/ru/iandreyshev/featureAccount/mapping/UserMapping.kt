package ru.iandreyshev.featureAccount.mapping

import ru.iandreyshev.featureAccount.storage.UserStorageEntity
import ru.iandreyshev.featureAccountApi.data.User

fun UserStorageEntity.toUser() =
        User(
                login = login,
                fullName = fullName,
                avatarUrl = avatarUrl
        )