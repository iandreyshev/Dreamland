package ru.iandreyshev.featureAccount.database

import io.objectbox.Box
import io.objectbox.rx.RxQuery
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import ru.iandreyshev.featureAccount.di.FeatureAccountComponent
import javax.inject.Inject

class UserDatabase : IUserDatabase {

    @Inject
    lateinit var mBox: Box<UserDatabaseEntity>

    init {
        FeatureAccountComponent.get().inject(this)
    }

    override val userObservable: Observable<UserDatabaseEntity?>
        get() = RxQuery.observable(mBox.query().build())
                .observeOn(Schedulers.io())
                .map { it.firstOrNull() }

    override fun saveUser(user: UserDatabaseEntity) {
        mBox.removeAll()
        mBox.put(user)
    }

    override fun clear() {
        mBox.removeAll()
    }

}
