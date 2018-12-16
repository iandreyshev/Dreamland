package ru.iandreyshev.featureAccount.mapping

import ru.iandreyshev.featureAccount.storage.UserStorageEntity
import ru.iandreyshev.featureAccount.network.parser.SignInResponseJson
import ru.iandreyshev.featureAccount.network.request.SignInRequest
import ru.iandreyshev.featureAccount.network.response.SignInResponse
import ru.iandreyshev.featureAccountApi.data.SignInProperties
import ru.iandreyshev.featureAccountApi.data.SignInResult

internal fun SignInProperties.toRequest() =
        SignInRequest(email, password)

internal fun SignInResponse.Account.toStorageEntity(password: String) =
        UserStorageEntity(
                id = id,
                fullName = fullName,
                password = password,
                avatarUrl = avatarUrl ?: ""
        )

internal fun SignInResponse.Error.toResult() =
        when (this) {
            SignInResponse.Error.USER_NOT_EXISTS -> SignInResult.ERROR_USER_NOT_EXISTS
            SignInResponse.Error.INCORRECT_DATA -> SignInResult.ERROR_INCORRECT_DATA
            SignInResponse.Error.NO_CONNECTION -> SignInResult.ERROR_NO_CONNECTION
            SignInResponse.Error.SERVER_ERROR -> SignInResult.ERROR_UNKNOWN
        }

internal fun SignInResponseJson.toApplicationModel(): SignInResponse {
    when (error) {
        SignInResponseJson.Error.USER_NOT_EXISTS ->
            return SignInResponse(SignInResponse.Error.USER_NOT_EXISTS)
        SignInResponseJson.Error.INCORRECT_DATA ->
            return SignInResponse(SignInResponse.Error.INCORRECT_DATA)
    }

    val accountFromResponse = account
            ?: return SignInResponse(SignInResponse.Error.SERVER_ERROR)

    return SignInResponse(SignInResponse.Account(
            id = accountFromResponse.id,
            fullName = accountFromResponse.name,
            avatarUrl = accountFromResponse.avatarUrl
    ))
}
