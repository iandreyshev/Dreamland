package ru.iandreyshev.featureDreams.useCase.impl

import io.reactivex.Single
import ru.iandreyshev.featureAccountApi.api.IUserApi
import ru.iandreyshev.featureDreams.useCase.IFetchDreamsUseCase
import ru.iandreyshev.featureDreams.domain.FetchDreamsResult
import ru.iandreyshev.featureDreams.mapping.toEntity
import ru.iandreyshev.featureDreams.mapping.toFetchDreamsRequest
import ru.iandreyshev.featureDreams.mapping.toResult
import ru.iandreyshev.featureDreams.network.IDreamsServerApi
import ru.iandreyshev.featureDreams.storage.IDreamsStorage
import javax.inject.Inject

class FetchDreamsUseCase
@Inject constructor(
        private val storage: IDreamsStorage,
        private val serverApi: IDreamsServerApi,
        private val userApi: IUserApi
) : IFetchDreamsUseCase {

    override fun invoke(): Single<FetchDreamsResult> = Single.create {
        val user = userApi.user ?: run {
            it.onSuccess(FetchDreamsResult.ERROR_UNDEFINED)
            return@create
        }

        val request = toFetchDreamsRequest(user)
        val response = serverApi.fetchDreams(request)

        response.error?.run {
            it.onSuccess(response.error.toResult())
            return@create
        }

        val dreams = response.result?.dreams ?: run {
            it.onSuccess(FetchDreamsResult.ERROR_UNDEFINED)
            return@create
        }

        storage.clear()
        storage.save(dreams.map { dream ->
            dream.toEntity()
        })
        it.onSuccess(FetchDreamsResult.SUCCESS)
    }

}