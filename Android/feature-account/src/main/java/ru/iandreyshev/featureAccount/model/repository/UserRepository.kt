package ru.iandreyshev.featureAccount.model.repository

import io.objectbox.BoxStore
import io.objectbox.rx.RxQuery
import io.reactivex.Completable
import io.reactivex.SingleObserver
import ru.iandreyshev.featureAccount.model.storage.AccountEntity

internal class UserRepository(boxStore: BoxStore) : IUserRepository {

    private val mAccountBox by lazy {
        boxStore.boxFor(AccountEntity::class.java)
    }
    private val mAllAccountsQuery by lazy {
        mAccountBox.query().build()
    }

    override fun getUser(observer: SingleObserver<IUser>) {
        RxQuery.single(mAllAccountsQuery)
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
