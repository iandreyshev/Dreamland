package ru.iandreyshev.coreAndroid.rx

import io.reactivex.Single
import io.reactivex.disposables.Disposable

fun <T> Single<T>.subscribe(onResult: (T) -> Unit, onError: (Throwable) -> Unit, afterAll: () -> Unit): Disposable =
        subscribe { result, error ->
            result?.let(onResult)
            error?.let(onError)
            afterAll()
        }
