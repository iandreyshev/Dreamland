package ru.iandreyshev.featureDreams.mapping

import ru.iandreyshev.featureAccountApi.data.User
import ru.iandreyshev.featureDreams.domain.FetchDreamsResult
import ru.iandreyshev.featureDreams.network.parser.DreamJson
import ru.iandreyshev.featureDreams.network.parser.FetchResponseJson
import ru.iandreyshev.featureDreams.network.request.FetchDreamsRequest
import ru.iandreyshev.featureDreams.network.response.FetchDreamsResponse
import ru.iandreyshev.featureDreams.storage.entity.DreamStorageEntity
import ru.iandreyshev.featureDreamsApi.domain.SleepingDate

fun toFetchDreamsRequest(user: User): FetchDreamsRequest =
        FetchDreamsRequest(
                userId = user.id,
                userPassword = user.password
        )

fun FetchDreamsResponse.Error.toResult(): FetchDreamsResult =
        when (this) {
            FetchDreamsResponse.Error.NO_CONNECTION ->
                FetchDreamsResult.ERROR_NO_CONNECTION
            FetchDreamsResponse.Error.USER_NOT_EXISTS,
            FetchDreamsResponse.Error.SERVER_ERROR ->
                FetchDreamsResult.ERROR_UNDEFINED
        }

fun DreamJson.toEntity(): DreamStorageEntity =
        DreamStorageEntity(
                id = id,
                description = description,
                date = SleepingDate(sleepingDate),
                isLucid = isLucid
        )

fun FetchResponseJson.toApplicationModel(): FetchDreamsResponse =
        when (error) {
            FetchResponseJson.Error.USER_NOT_EXISTS ->
                FetchDreamsResponse(FetchDreamsResponse.Error.USER_NOT_EXISTS)
            FetchResponseJson.Error.UNDEFINED ->
                FetchDreamsResponse(FetchDreamsResponse.Error.SERVER_ERROR)
            null -> {
                val result = FetchDreamsResponse.Result(dreams ?: listOf())
                FetchDreamsResponse(result)
            }
        }
