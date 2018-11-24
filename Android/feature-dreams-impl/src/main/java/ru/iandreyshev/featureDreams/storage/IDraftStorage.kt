package ru.iandreyshev.featureDreams.storage

import io.reactivex.Observable
import ru.iandreyshev.featureDreams.storage.entity.DraftStorageEntity

interface IDraftStorage {
    val draftObservable: Observable<DraftStorageEntity>
    fun save(draft: DraftStorageEntity)
    fun clear()
}
