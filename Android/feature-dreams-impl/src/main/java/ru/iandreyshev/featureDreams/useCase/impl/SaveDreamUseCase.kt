package ru.iandreyshev.featureDreams.useCase.impl

import io.reactivex.Single
import ru.iandreyshev.coreAndroid.rx.ioToMain
import ru.iandreyshev.featureDreams.storage.IDreamsStorage
import ru.iandreyshev.featureDreams.network.IDreamsServerApi
import ru.iandreyshev.featureDreams.useCase.ISaveDreamUseCase
import ru.iandreyshev.featureDreams.domain.DreamProperties
import ru.iandreyshev.featureDreams.domain.DreamSyncState
import ru.iandreyshev.featureDreams.domain.SaveDreamResult
import ru.iandreyshev.featureDreams.storage.entity.DreamStorageEntity
import ru.iandreyshev.featureDreamsApi.data.DreamKey
import javax.inject.Inject

class SaveDreamUseCase
@Inject constructor(
        private val storage: IDreamsStorage,
        private val serverApi: IDreamsServerApi
) : ISaveDreamUseCase {

    override fun invoke(dream: DreamProperties, key: DreamKey?) = Single.create<SaveDreamResult> {
        val entity = DreamStorageEntity(
                syncState = DreamSyncState.WAIT,
                description = dream.description
        )
        storage.save(entity)
        it.onSuccess(SaveDreamResult())
    }.ioToMain()

}