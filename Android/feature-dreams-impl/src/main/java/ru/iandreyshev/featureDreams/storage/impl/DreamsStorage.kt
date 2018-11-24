package ru.iandreyshev.featureDreams.storage.impl

import io.reactivex.Observable
import ru.iandreyshev.featureDreams.storage.IDreamsStorage
import ru.iandreyshev.featureDreams.storage.entity.DreamStorageEntity
import ru.iandreyshev.featureDreamsApi.data.DreamIdentifier
import javax.inject.Inject

class DreamsStorage
@Inject constructor() : IDreamsStorage {

    override val dreamObservable: Observable<List<DreamStorageEntity>>
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override fun save(dream: DreamStorageEntity) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun save(dream: List<DreamStorageEntity>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(identifier: DreamIdentifier) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun clear() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}