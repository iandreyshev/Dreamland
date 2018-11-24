package ru.iandreyshev.featureDreams.repository

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import ru.iandreyshev.coreAndroid.rx.ioToMain
import ru.iandreyshev.featureDreamsApi.api.IDreamsRepository
import ru.iandreyshev.featureDreamsApi.data.DreamListItem
import javax.inject.Inject

class DreamsRepository
@Inject constructor() : IDreamsRepository {

    private val mCountSubject = PublishSubject.create<Int>()
    private var mRefreshesCount = 0

    override val dreamsObservable: Observable<List<DreamListItem>>
        get() = Observable.just(listOf())

    override fun refresh(): Completable = Completable.create {
        Thread.sleep(1500)
        if (mRefreshesCount < 2) {
            mRefreshesCount++
            mCountSubject.onNext(0)
        } else {
            mCountSubject.onNext(1)
        }
        it.onComplete()
    }.ioToMain()

}
