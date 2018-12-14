package ru.iandreyshev.featureDreams.storage.impl

import io.objectbox.Box
import io.objectbox.rx.RxQuery
import io.reactivex.Observable
import ru.iandreyshev.coreAndroid.rx.ioToMain
import ru.iandreyshev.featureDreams.storage.IDreamsStorage
import ru.iandreyshev.featureDreams.storage.entity.DreamStorageEntity
import ru.iandreyshev.featureDreams.storage.entity.DreamStorageEntity_
import ru.iandreyshev.featureDreamsApi.domain.DreamKey
import javax.inject.Inject

class DreamsStorage
@Inject constructor(
        private val dreamsBox: Box<DreamStorageEntity>
) : IDreamsStorage {

    override val dreamObservable: Observable<List<DreamStorageEntity>>
        get() = RxQuery.observable(dreamsBox.query().notNull(DreamStorageEntity_.__ID_PROPERTY).build())
                .ioToMain()

    override fun save(dream: DreamStorageEntity) {
        dreamsBox.all
        dreamsBox.put(dream)
    }

    override fun save(dreams: List<DreamStorageEntity>) {
        dreamsBox.put(dreams)
    }

    override fun delete(key: DreamKey) {
        dreamsBox.remove(key.id)
    }

    override fun clear() {
        dreamsBox.removeAll()
    }

}