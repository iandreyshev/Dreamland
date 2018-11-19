package ru.iandreyshev.featureAccount.mapping

import ru.iandreyshev.featureAccount.network.parser.DeleteResponseJson
import ru.iandreyshev.featureAccount.network.response.DeleteResponse
import ru.iandreyshev.featureAccountApi.data.DeleteUserResult

internal fun DeleteResponse.toResult(): DeleteUserResult {
    return when (result) {
        DeleteResponse.Result.SUCCESS -> DeleteUserResult.SUCCESS
        DeleteResponse.Result.NO_CONNECTION -> DeleteUserResult.NO_CONNECTION
        DeleteResponse.Result.USER_NOT_EXISTS,
        DeleteResponse.Result.SERVER_ERROR -> DeleteUserResult.UNKNOWN
    }
}

internal fun DeleteResponseJson.toApplicationModel(): DeleteResponse {
    return when (error) {
        DeleteResponseJson.Error.USER_NOT_EXISTS ->
            DeleteResponse(DeleteResponse.Result.USER_NOT_EXISTS)
        null ->
            DeleteResponse(DeleteResponse.Result.SUCCESS)
    }
}
