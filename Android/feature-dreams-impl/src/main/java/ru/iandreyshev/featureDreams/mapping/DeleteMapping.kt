package ru.iandreyshev.featureDreams.mapping

import ru.iandreyshev.featureAccountApi.data.User
import ru.iandreyshev.featureDreams.domain.DeleteDreamResult
import ru.iandreyshev.featureDreams.network.parser.DeleteResponseJson
import ru.iandreyshev.featureDreams.network.request.DeleteDreamRequest
import ru.iandreyshev.featureDreams.network.response.DeleteResponse
import ru.iandreyshev.featureDreamsApi.domain.DreamKey

fun DreamKey.toRequest(user: User): DeleteDreamRequest =
        DeleteDreamRequest(
                userId = user.id,
                userPassword = user.password,
                id = id
        )

fun DeleteResponse.toResult(): DeleteDreamResult =
        when (this) {
            DeleteResponse.SUCCESS -> DeleteDreamResult.SUCCESS
            DeleteResponse.ERROR_NO_CONNECTION -> DeleteDreamResult.ERROR_NO_CONNECTION
            DeleteResponse.ERROR_USER_NOT_EXISTS,
            DeleteResponse.ERROR_SERVER_ERROR -> DeleteDreamResult.ERROR_UNDEFINED
        }

fun DeleteResponseJson.toApplicationModel(): DeleteResponse =
        when (error) {
            DeleteResponseJson.Error.USER_NOT_EXISTS -> DeleteResponse.ERROR_USER_NOT_EXISTS
            DeleteResponseJson.Error.UNDEFINED -> DeleteResponse.ERROR_SERVER_ERROR
            null -> DeleteResponse.SUCCESS
        }