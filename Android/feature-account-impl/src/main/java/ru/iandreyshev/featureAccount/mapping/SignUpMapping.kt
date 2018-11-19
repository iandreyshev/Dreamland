package ru.iandreyshev.featureAccount.mapping

import ru.iandreyshev.featureAccount.database.UserDatabaseEntity
import ru.iandreyshev.featureAccount.network.parser.SignUpResponseJson
import ru.iandreyshev.featureAccount.network.request.SignUpRequest
import ru.iandreyshev.featureAccount.network.response.SignUpResponse
import ru.iandreyshev.featureAccountApi.data.SignUpProperties
import ru.iandreyshev.featureAccountApi.data.SignUpResult

internal fun SignUpProperties.toRequest() =
        SignUpRequest(
                email = email,
                fullName = fullName,
                password = password
        )

internal fun SignUpResponse.Account.toDatabaseEntity(password: String) =
        UserDatabaseEntity(
                accountId = id,
                fullName = fullName,
                password = password,
                avatarUrl = avatarUrl
        )

internal fun SignUpResponse.Error.toResult() =
        when (this) {
            SignUpResponse.Error.USER_ALREADY_EXISTS -> SignUpResult.USER_ALREADY_EXISTS
            SignUpResponse.Error.INCORRECT_DATA -> SignUpResult.INCORRECT_DATA
            SignUpResponse.Error.NO_CONNECTION -> SignUpResult.NO_CONNECTION
            SignUpResponse.Error.SERVER_ERROR -> SignUpResult.UNKNOWN
        }

internal fun SignUpResponseJson.toApplicationModel(): SignUpResponse {
    when (error) {
        SignUpResponseJson.Error.USER_ALREADY_EXISTS ->
            return SignUpResponse(SignUpResponse.Error.USER_ALREADY_EXISTS)
        SignUpResponseJson.Error.INCORRECT_DATA ->
            return SignUpResponse(SignUpResponse.Error.INCORRECT_DATA)
    }

    val accountFromResponse = account
            ?: return SignUpResponse(SignUpResponse.Error.SERVER_ERROR)

    return SignUpResponse(SignUpResponse.Account(
            id = accountFromResponse.id,
            fullName = accountFromResponse.name,
            avatarUrl = accountFromResponse.avatarUrl
    ))
}
