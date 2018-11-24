package ru.iandreyshev.featureAccount.storage

import io.objectbox.Box
import io.objectbox.rx.RxQuery
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class UserStorage
@Inject constructor(
        private val box: Box<UserStorageEntity>
) : IUserStorage {

    override val user: UserStorageEntity?
        get() = box.all.firstOrNull()

    override val userObservable: Observable<UserStorageEntity>
        get() = RxQuery.observable(box.query().build())
                .observeOn(Schedulers.io())
                .map { it.firstOrNull() ?: UserStorageEntity() }

    override val isUserExists: Boolean
        get() = user != null

    override fun saveUser(user: UserStorageEntity) {
        box.removeAll()
        box.put(user)
    }

    override fun clear() {
        box.removeAll()
    }

}
