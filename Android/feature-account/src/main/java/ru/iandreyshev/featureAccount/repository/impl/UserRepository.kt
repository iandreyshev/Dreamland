package ru.iandreyshev.featureAccount.repository.impl

import io.objectbox.Box
import io.objectbox.rx.RxQuery
import io.reactivex.*
import ru.iandreyshev.featureAccount.repository.IUser
import ru.iandreyshev.featureAccount.repository.IUserRepository
import ru.iandreyshev.featureAccount.repository.storage.AccountEntity
import javax.inject.Inject

internal class UserRepository : IUserRepository {

    @Inject
    lateinit var userBox: Box<AccountEntity>

    private val mAuthStateObservable = Observable.create<AuthState> {
        it.onNext(AuthState.NOT_EXISTS)
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

    override fun getUserAuthState(): Observable<AuthState> {
        return mAuthStateObservable
    }

}
