package ru.iandreyshev.featureDreams.useCase.impl

import ru.iandreyshev.featureDreams.network.IDreamsServerApi
import ru.iandreyshev.featureDreams.storage.IDreamsStorage
import ru.iandreyshev.featureDreams.useCase.ISyncDreamsUseCase
import javax.inject.Inject

class SyncDreamsUseCase
@Inject constructor(
        private val serverApi: IDreamsServerApi,
        private val storage: IDreamsStorage
) : ISyncDreamsUseCase {

    override fun invoke() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}