package ru.iandreyshev.featureDreams.useCase.impl

import io.reactivex.Single
import ru.iandreyshev.featureAccountApi.api.IUserApi
import ru.iandreyshev.featureDreams.storage.IDreamsStorage
import ru.iandreyshev.featureDreams.network.IDreamsServerApi
import ru.iandreyshev.featureDreams.useCase.IDeleteDreamUseCase
import ru.iandreyshev.featureDreams.domain.DeleteDreamResult
import ru.iandreyshev.featureDreams.mapping.toRequest
import ru.iandreyshev.featureDreams.mapping.toResult
import ru.iandreyshev.featureDreams.network.response.DeleteResponse
import ru.iandreyshev.featureDreamsApi.domain.DreamKey
import javax.inject.Inject

class DeleteDreamUseCase
@Inject constructor(
        private val storage: IDreamsStorage,
        private val serverApi: IDreamsServerApi,
        private val userApi: IUserApi
) : IDeleteDreamUseCase {

    override fun invoke(key: DreamKey): Single<DeleteDreamResult> = Single.create {
        val user = userApi.user ?: run {
            it.onSuccess(DeleteDreamResult.ERROR_UNDEFINED)
            return@create
        }
        val request = key.toRequest(user)
        val response = serverApi.delete(request)

        if (response != DeleteResponse.SUCCESS) {
            it.onSuccess(response.toResult())
            return@create
        }

        storage.delete(key)
        it.onSuccess(DeleteDreamResult.SUCCESS)
    }

}