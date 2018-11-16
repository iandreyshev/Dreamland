package ru.iandreyshev.featureAccount.mapping

import ru.iandreyshev.featureAccount.database.UserDatabaseEntity
import ru.iandreyshev.featureAccount.network.request.SignInRequest
import ru.iandreyshev.featureAccount.network.response.SignInResponse
import ru.iandreyshev.featureAccountApi.data.SignInProperties
import ru.iandreyshev.featureAccountApi.data.SignInResult

internal fun SignInProperties.toRequest() =
        SignInRequest(login, password)

internal fun SignInResponse.Account.toDatabaseEntity(password: String) =
        UserDatabaseEntity(
                accountId = id,
                fullName = fullName,
                password = password,
                avatarUrl = avatarUrl
        )

internal fun SignInResponse.Error.toResult() =
        when (this) {
            SignInResponse.Error.USER_NOT_EXISTS -> SignInResult.USER_NOT_EXISTS
            SignInResponse.Error.INCORRECT_DATA -> SignInResult.INCORRECT_DATA
            SignInResponse.Error.NO_CONNECTION -> SignInResult.NO_CONNECTION
            SignInResponse.Error.SERVER_ERROR -> SignInResult.UNKNOWN
        }
