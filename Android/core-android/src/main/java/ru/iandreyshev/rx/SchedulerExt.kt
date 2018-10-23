package ru.iandreyshev.rx

import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

private val IO_SCHEDULER = Schedulers.io()
private val MAIN_THREAD_SCHEDULER = AndroidSchedulers.mainThread()

fun <T> Observable<T>.ioToMain(): Observable<T> = compose { upstream ->
    upstream.subscribeOn(IO_SCHEDULER)
            .observeOn(MAIN_THREAD_SCHEDULER)
}

fun <T> Single<T>.ioToMain(): Single<T> = compose { upstream ->
    upstream.subscribeOn(IO_SCHEDULER)
            .observeOn(MAIN_THREAD_SCHEDULER)
}

fun Completable.ioToMain(): Completable = compose { upstream ->
    upstream.subscribeOn(IO_SCHEDULER)
            .observeOn(MAIN_THREAD_SCHEDULER)
}

fun <T> Flowable<T>.ioToMain(): Flowable<T> = compose { upstream ->
    upstream.subscribeOn(IO_SCHEDULER)
            .observeOn(MAIN_THREAD_SCHEDULER)
}

fun <T> Maybe<T>.ioToMain(): Maybe<T> = compose { upstream ->
    upstream.subscribeOn(IO_SCHEDULER)
            .observeOn(MAIN_THREAD_SCHEDULER)
}