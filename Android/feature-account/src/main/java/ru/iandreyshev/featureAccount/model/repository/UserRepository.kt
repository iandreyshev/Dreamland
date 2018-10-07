package ru.iandreyshev.featureAccount.model.repository

import io.objectbox.Box
import io.objectbox.rx.RxQuery
import io.reactivex.Completable
import io.reactivex.SingleObserver
import ru.iandreyshev.featureAccount.model.storage.AccountEntity
import javax.inject.Inject

internal class UserRepository : IUserRepository {

    @Inject
    lateinit var userBox: Box<AccountEntity>

    override fun getUser(observer: SingleObserver<IUser>) {
        val query = userBox.query().build()
        RxQuery.single(query)
                .map {
                    val account = it.firstOrNull()?.toAccount()
                    return@map User(account)
                }
                .subscribe(observer)
    }

    override fun signIn(loginData: IAuthProperties, observer: SingleObserver<IAccount>) {
        TODO("signIn not implemented")
    }

    override fun signOut(): Completable {
        TODO("signOut not implemented")
    }

}
