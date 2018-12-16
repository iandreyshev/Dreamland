package ru.iandreyshev.featureAccount.mapping

import ru.iandreyshev.featureAccount.storage.UserStorageEntity
import ru.iandreyshev.featureAccountApi.data.User

fun UserStorageEntity.toUser() =
        User(
                id = id,
                login = login,
                password = password,
                fullName = fullName,
                avatarUrl = avatarUrl
        )