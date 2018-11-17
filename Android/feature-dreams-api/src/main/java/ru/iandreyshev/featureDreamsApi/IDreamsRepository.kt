package ru.iandreyshev.featureDreamsApi

import io.reactivex.Completable
import io.reactivex.Observable

interface IDreamsRepository {
    val countObservable: Observable<Int>
    fun refresh(): Completable
}
