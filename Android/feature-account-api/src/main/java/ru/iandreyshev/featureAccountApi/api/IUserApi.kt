package ru.iandreyshev.featureAccountApi.api

import io.reactivex.Observable
import ru.iandreyshev.featureAccountApi.data.User

interface IUserApi {
    val observable: Observable<User>
}
