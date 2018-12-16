package ru.iandreyshev.featureAccount.api

import io.reactivex.Observable
import ru.iandreyshev.featureAccount.storage.IUserStorage
import ru.iandreyshev.featureAccount.mapping.toUser
import ru.iandreyshev.featureAccountApi.data.User
import ru.iandreyshev.featureAccountApi.api.IUserApi
import javax.inject.Inject

class UserObservableApi
@Inject constructor(
        private val storage: IUserStorage
) : IUserApi {

    override val user: User?
        get() = storage.user?.toUser()

    override val observable: Observable<User>
        get() = storage.userObservable
                .map { it.toUser() }

}
