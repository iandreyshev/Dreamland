package ru.iandreyshev.featureAccount.repository

import io.objectbox.Box
import io.objectbox.rx.RxQuery
import io.reactivex.*
import ru.iandreyshev.featureAccount.repository.storage.AccountEntity
import javax.inject.Inject

internal class UserRepository : IUserRepository {

    @Inject
    lateinit var userBox: Box<AccountEntity>

    private val mAuthStateObservable = Observable.create<Boolean> {
        it.onNext(false)
        it.onComplete()
    }

    override fun getUser(): Observable<IUser> {
        return RxQuery.observable(userBox.query().build())
                .map { entity ->
                    entity.firstOrNull()?.let {
                        User(it)
                    }
                }
    }

    override fun getUserAuthState(): Observable<Boolean> {
        return mAuthStateObservable
    }

    override fun refresh() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}