package ru.iandreyshev.featureDreamsApi.api

import io.reactivex.Observable
import ru.iandreyshev.featureDreamsApi.domain.Dream
import ru.iandreyshev.featureDreamsApi.domain.DreamKey
import ru.iandreyshev.featureDreamsApi.domain.LoadDreamResult

interface IDreamsRepository {
    val dreamsObservable: Observable<List<Dream>>
    fun getDreamObservable(key: DreamKey): Observable<LoadDreamResult>
}
