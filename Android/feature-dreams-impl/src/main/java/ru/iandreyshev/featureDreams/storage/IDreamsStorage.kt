package ru.iandreyshev.featureDreams.storage

import io.reactivex.Observable
import ru.iandreyshev.featureDreams.storage.entity.DreamStorageEntity
import ru.iandreyshev.featureDreamsApi.data.DreamIdentifier

interface IDreamsStorage {
    val dreamObservable: Observable<List<DreamStorageEntity>>
    fun save(dream: DreamStorageEntity)
    fun save(dream: List<DreamStorageEntity>)
    fun delete(identifier: DreamIdentifier)
    fun clear()
}
