package ru.iandreyshev.featureDreams.useCase.impl

import io.reactivex.Single
import ru.iandreyshev.featureDreams.storage.IDreamsStorage
import ru.iandreyshev.featureDreams.network.IDreamsServerApi
import ru.iandreyshev.featureDreams.useCase.IEditDreamUseCase
import ru.iandreyshev.featureDreamsApi.data.DreamIdentifier
import ru.iandreyshev.featureDreams.domain.DreamProperties
import ru.iandreyshev.featureDreams.domain.EditDreamResult
import javax.inject.Inject

class EditDreamUseCase
@Inject constructor(
        private val storage: IDreamsStorage,
        private val serverApi: IDreamsServerApi
) : IEditDreamUseCase {

    override fun invoke(identifier: DreamIdentifier, dream: DreamProperties): Single<EditDreamResult> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}