package ru.iandreyshev.featureAccount.mapping

import ru.iandreyshev.featureAccount.network.parser.DeleteResponseJson
import ru.iandreyshev.featureAccount.network.response.DeleteResponse
import ru.iandreyshev.featureAccountApi.data.DeleteUserResult

internal fun DeleteResponse.toResult(): DeleteUserResult {
    return when (this) {
        DeleteResponse.SUCCESS -> DeleteUserResult.SUCCESS
        DeleteResponse.NO_CONNECTION -> DeleteUserResult.NO_CONNECTION
        DeleteResponse.USER_NOT_EXISTS,
        DeleteResponse.SERVER_ERROR -> DeleteUserResult.UNKNOWN
    }
}

internal fun DeleteResponseJson.toApplicationModel(): DeleteResponse {
    return when (error) {
        DeleteResponseJson.Error.USER_NOT_EXISTS ->
            DeleteResponse.USER_NOT_EXISTS
        null ->
            DeleteResponse.SUCCESS
    }
}
