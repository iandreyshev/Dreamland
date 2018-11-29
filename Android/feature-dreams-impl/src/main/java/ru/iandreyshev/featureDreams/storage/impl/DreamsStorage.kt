package ru.iandreyshev.featureDreams.storage.impl

import io.objectbox.Box
import io.objectbox.rx.RxQuery
import io.reactivex.Observable
import ru.iandreyshev.featureDreams.storage.IDreamsStorage
import ru.iandreyshev.featureDreams.storage.entity.DreamStorageEntity
import ru.iandreyshev.featureDreams.storage.entity.DreamStorageEntity_
import ru.iandreyshev.featureDreamsApi.data.DreamIdentifier
import javax.inject.Inject

class DreamsStorage
@Inject constructor(
        private val dreamsBox: Box<DreamStorageEntity>
) : IDreamsStorage {

    override val dreamObservable: Observable<List<DreamStorageEntity>>
        get() = RxQuery.observable(dreamsBox.query().notNull(DreamStorageEntity_.__ID_PROPERTY).build())

    override fun save(dream: DreamStorageEntity) {
        dreamsBox.put(dream)
    }

    override fun save(dream: List<DreamStorageEntity>) {
    }

    override fun delete(identifier: DreamIdentifier) {
    }

    override fun clear() {
    }

}