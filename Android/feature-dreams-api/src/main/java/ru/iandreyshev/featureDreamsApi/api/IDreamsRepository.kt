package ru.iandreyshev.featureDreamsApi.api

import io.reactivex.Completable
import io.reactivex.Observable
import ru.iandreyshev.featureDreamsApi.data.DreamListItem

interface IDreamsRepository {
    val dreamsObservable: Observable<List<DreamListItem>>
    fun refresh(): Completable
}
