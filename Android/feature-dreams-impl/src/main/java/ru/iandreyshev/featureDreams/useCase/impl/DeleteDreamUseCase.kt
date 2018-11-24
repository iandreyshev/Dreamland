package ru.iandreyshev.featureDreams.useCase.impl

import io.reactivex.Single
import ru.iandreyshev.featureDreams.storage.IDreamsStorage
import ru.iandreyshev.featureDreams.network.IDreamsServerApi
import ru.iandreyshev.featureDreams.useCase.IDeleteDreamUseCase
import ru.iandreyshev.featureDreams.domain.DeleteDreamResult
import ru.iandreyshev.featureDreamsApi.data.DreamIdentifier
import javax.inject.Inject

class DeleteDreamUseCase
@Inject constructor(
        private val storage: IDreamsStorage,
        private val serverApi: IDreamsServerApi
) : IDeleteDreamUseCase {

    override fun invoke(identifier: DreamIdentifier): Single<DeleteDreamResult> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}