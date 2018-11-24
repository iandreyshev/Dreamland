package ru.iandreyshev.featureDreams.storage.impl

import io.reactivex.Observable
import ru.iandreyshev.featureDreams.storage.IDraftStorage
import ru.iandreyshev.featureDreams.storage.entity.DraftStorageEntity
import javax.inject.Inject

class DraftStorage
@Inject constructor(): IDraftStorage {

    override val draftObservable: Observable<DraftStorageEntity>
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override fun save(draft: DraftStorageEntity) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun clear() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}