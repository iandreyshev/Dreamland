package ru.iandreyshev.featureDreams.useCase.impl

import io.reactivex.Single
import ru.iandreyshev.featureDreams.storage.IDreamsStorage
import ru.iandreyshev.featureDreams.network.IDreamsServerApi
import ru.iandreyshev.featureDreams.useCase.ISaveDreamUseCase
import ru.iandreyshev.featureDreamsApi.data.DreamIdentifier
import ru.iandreyshev.featureDreams.domain.DreamProperties
import ru.iandreyshev.featureDreams.domain.SaveDreamResult
import javax.inject.Inject

class SaveDreamUseCase
@Inject constructor(
        private val storage: IDreamsStorage,
        private val serverApi: IDreamsServerApi
) : ISaveDreamUseCase {

    override fun invoke(identifier: DreamIdentifier?, dream: DreamProperties): Single<SaveDreamResult> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}