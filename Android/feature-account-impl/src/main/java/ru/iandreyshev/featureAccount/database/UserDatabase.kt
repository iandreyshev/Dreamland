package ru.iandreyshev.featureAccount.database

import io.objectbox.Box
import io.objectbox.rx.RxQuery
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class UserDatabase
@Inject constructor(
        private val box: Box<UserDatabaseEntity>
) : IUserDatabase {

    override val userObservable: Observable<UserDatabaseEntity?>
        get() = RxQuery.observable(box.query().build())
                .observeOn(Schedulers.io())
                .map { it.firstOrNull() }

    override fun saveUser(user: UserDatabaseEntity) {
        box.removeAll()
        box.put(user)
    }

    override fun clear() {
        box.removeAll()
    }

}
