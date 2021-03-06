package ru.iandreyshev.featureDreams.storage

import io.reactivex.Observable
import ru.iandreyshev.featureDreams.storage.entity.DreamStorageEntity
import ru.iandreyshev.featureDreamsApi.domain.DreamKey

interface IDreamsStorage {
    val dreamObservable: Observable<List<DreamStorageEntity>>
    fun save(dream: DreamStorageEntity)
    fun save(dreams: List<DreamStorageEntity>)
    fun delete(key: DreamKey)
    fun clear()
}
