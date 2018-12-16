package ru.iandreyshev.featureDreams.mapping

import ru.iandreyshev.featureAccountApi.data.User
import ru.iandreyshev.featureDreams.domain.SaveDreamResult
import ru.iandreyshev.featureDreams.network.parser.SaveResponseJson
import ru.iandreyshev.featureDreams.network.request.SaveRequest
import ru.iandreyshev.featureDreams.network.response.SaveResponse
import ru.iandreyshev.featureDreams.storage.entity.DreamStorageEntity
import ru.iandreyshev.featureDreamsApi.domain.DreamProperties

fun DreamProperties.toRequest(user: User): SaveRequest =
        SaveRequest(
                userId = user.id,
                userPassword = user.password,
                description = description,
                isLucid = isLucid,
                sleepingDate = sleepingDate.timesTemp
        )

fun SaveResponse.Error?.toResult(): SaveDreamResult =
        when (this) {
            SaveResponse.Error.NO_CONNECTION -> SaveDreamResult.ERROR_NO_CONNECTION
            SaveResponse.Error.USER_NOT_EXISTS -> SaveDreamResult.ERROR_UNDEFINED
            SaveResponse.Error.INCORRECT_DATA -> SaveDreamResult.ERROR_UNDEFINED
            SaveResponse.Error.SERVER_ERROR -> SaveDreamResult.ERROR_UNDEFINED
            null -> SaveDreamResult.ERROR_UNDEFINED
        }

fun DreamProperties.toEntity(serverResult: SaveResponse.Result): DreamStorageEntity =
        DreamStorageEntity(
                id = serverResult.id,
                description = description,
                date = sleepingDate,
                isLucid = isLucid
        )

fun SaveResponseJson.toApplicationModel(): SaveResponse =
        when (error) {
            SaveResponseJson.Error.USER_NOT_EXISTS ->
                SaveResponse(SaveResponse.Error.USER_NOT_EXISTS)
            SaveResponseJson.Error.UNDEFINED ->
                SaveResponse(SaveResponse.Error.SERVER_ERROR)
            null -> dreamId?.run {
                SaveResponse(SaveResponse.Result(this))
            } ?: SaveResponse(SaveResponse.Error.SERVER_ERROR)
        }