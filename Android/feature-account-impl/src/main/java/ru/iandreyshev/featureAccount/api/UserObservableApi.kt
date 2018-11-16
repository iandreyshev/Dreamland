package ru.iandreyshev.featureAccount.api

import io.reactivex.Observable
import ru.iandreyshev.coreAndroid.rx.ioToMain
import ru.iandreyshev.featureAccount.database.IUserDatabase
import ru.iandreyshev.featureAccount.mapping.toUser
import ru.iandreyshev.featureAccountApi.data.User
import ru.iandreyshev.featureAccountApi.observable.IUserApi
import javax.inject.Inject

class UserObservableApi
@Inject constructor(
        private val database: IUserDatabase
) : IUserApi {

    override val observable: Observable<User>
        get() = database.userObservable
                .map { it.toUser() }
                .ioToMain()

}
