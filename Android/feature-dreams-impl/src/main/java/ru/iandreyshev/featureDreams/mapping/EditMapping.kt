package ru.iandreyshev.featureDreams.mapping

import ru.iandreyshev.featureAccountApi.data.User
import ru.iandreyshev.featureDreams.domain.SaveDreamResult
import ru.iandreyshev.featureDreams.network.parser.EditResponseJson
import ru.iandreyshev.featureDreams.network.request.EditRequest
import ru.iandreyshev.featureDreams.network.response.EditResponse
import ru.iandreyshev.featureDreams.storage.entity.DreamStorageEntity
import ru.iandreyshev.featureDreamsApi.domain.DreamKey
import ru.iandreyshev.featureDreamsApi.domain.DreamProperties

fun DreamProperties.toRequest(key: DreamKey, user: User): EditRequest =
        EditRequest(
                userId = user.id,
                userPassword = user.password,
                dreamId = key.id,
                description = description,
                isLucid = isLucid,
                sleepingDate = sleepingDate.timesTemp
        )

fun EditResponse.toResult(): SaveDreamResult =
        when (this) {
            EditResponse.SUCCESS -> SaveDreamResult.SUCCESS
            EditResponse.ERROR_NO_CONNECTION -> SaveDreamResult.ERROR_NO_CONNECTION
            EditResponse.USER_NOT_EXISTS -> SaveDreamResult.ERROR_UNDEFINED
            EditResponse.INCORRECT_DATA -> SaveDreamResult.ERROR_UNDEFINED
            EditResponse.ERROR_SERVER_ERROR -> SaveDreamResult.ERROR_UNDEFINED
        }

fun DreamProperties.toEntity(key: DreamKey) =
        DreamStorageEntity(
                id = key.id,
                date = sleepingDate,
                description = description,
                isLucid = isLucid
        )

fun EditResponseJson.toApplicationModel(): EditResponse =
        when (error) {
            EditResponseJson.Error.USER_NOT_EXISTS ->
                EditResponse.USER_NOT_EXISTS
            null ->
                EditResponse.SUCCESS
        }