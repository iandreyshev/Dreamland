package ru.iandreyshev.featureDreams.useCase.impl

import io.reactivex.Single
import ru.iandreyshev.featureDreams.storage.IDreamsStorage
import ru.iandreyshev.featureDreams.network.IDreamsServerApi
import ru.iandreyshev.featureDreams.useCase.ISaveDreamUseCase
import ru.iandreyshev.featureDreamsApi.domain.DreamProperties
import ru.iandreyshev.featureDreams.domain.DreamSyncState
import ru.iandreyshev.featureDreams.domain.SaveDreamResult
import ru.iandreyshev.featureDreams.storage.entity.DreamStorageEntity
import ru.iandreyshev.featureDreamsApi.domain.DreamKey
import javax.inject.Inject

class SaveDreamUseCase
@Inject constructor(
        private val storage: IDreamsStorage,
        private val serverApi: IDreamsServerApi
) : ISaveDreamUseCase {

    override fun invoke(dream: DreamProperties, key: DreamKey?): Single<SaveDreamResult> = Single.create {
        val entity = DreamStorageEntity(
                syncState = DreamSyncState.WAIT,
                description = dream.description
        )

        Thread.sleep(2000)

        storage.save(entity)
        it.onSuccess(SaveDreamResult())
    }

}