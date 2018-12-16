package ru.iandreyshev.featureDreams.useCase.impl

import io.reactivex.Single
import ru.iandreyshev.featureAccountApi.api.IUserApi
import ru.iandreyshev.featureDreams.storage.IDreamsStorage
import ru.iandreyshev.featureDreams.network.IDreamsServerApi
import ru.iandreyshev.featureDreams.useCase.ISaveDreamUseCase
import ru.iandreyshev.featureDreamsApi.domain.DreamProperties
import ru.iandreyshev.featureDreams.domain.SaveDreamResult
import ru.iandreyshev.featureDreams.mapping.toEntity
import ru.iandreyshev.featureDreams.mapping.toRequest
import ru.iandreyshev.featureDreams.mapping.toResult
import ru.iandreyshev.featureDreams.network.response.EditResponse
import ru.iandreyshev.featureDreamsApi.domain.DreamKey
import javax.inject.Inject

class SaveDreamUseCase
@Inject constructor(
        private val storage: IDreamsStorage,
        private val serverApi: IDreamsServerApi,
        private val userApi: IUserApi
) : ISaveDreamUseCase {

    override fun invoke(properties: DreamProperties, key: DreamKey?): Single<SaveDreamResult> = Single.create {
        val dream = properties.clear()

        dream.validate()?.run {
            it.onSuccess(this)
            return@create
        }

        val result = if (key == null) {
            save(dream)
        } else {
            edit(dream, key)
        }

        it.onSuccess(result)
    }

    private fun save(dreamProperties: DreamProperties): SaveDreamResult {
        val user = userApi.user ?: return SaveDreamResult.ERROR_UNDEFINED
        val request = dreamProperties.toRequest(user)
        val response = serverApi.save(request)
        val resultFromServer = response.result ?: run {
            return response.error.toResult()
        }

        val entity = dreamProperties.toEntity(resultFromServer)
        storage.save(entity)

        return SaveDreamResult.SUCCESS
    }

    private fun edit(dreamProperties: DreamProperties, key: DreamKey): SaveDreamResult {
        val user = userApi.user ?: return SaveDreamResult.ERROR_UNDEFINED
        val request = dreamProperties.toRequest(key, user)
        val response = serverApi.edit(request)

        if (response != EditResponse.SUCCESS) {
            return response.toResult()
        }

        val entity = dreamProperties.toEntity(key)
        storage.save(entity)

        return SaveDreamResult.SUCCESS
    }

    private fun DreamProperties.validate(): SaveDreamResult? {
        if (description.isEmpty()) {
            return SaveDreamResult.ERROR_EMPTY_DREAM
        }
        if (description.isBlank()) {
            return SaveDreamResult.ERROR_BLANK_DREAM
        }
        if (description.length > MAX_DREAM_DESCRIPTION_LENGTH) {
            return SaveDreamResult.ERROR_LARGE_DREAM
        }

        return null
    }

    private fun DreamProperties.clear(): DreamProperties =
            copy(description = description.trim())

    companion object {
        private const val MAX_DREAM_DESCRIPTION_LENGTH = 100
    }

}