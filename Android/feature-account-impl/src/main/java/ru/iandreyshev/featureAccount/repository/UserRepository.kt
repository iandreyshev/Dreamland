package ru.iandreyshev.featureAccount.repository

import io.reactivex.*
import ru.iandreyshev.featureAccountApi.repository.IUser
import ru.iandreyshev.featureAccountApi.repository.IUserRepository
//import ru.iandreyshev.featureAccount.repository.storage.AccountEntity

class UserRepository : IUserRepository {

//    @Inject
//    lateinit var userBox: Box<AccountEntity>

    private val mAuthStateObservable = Observable.create<Boolean> {
        it.onNext(false)
        it.onComplete()
    }

    override fun getUserObservable(): Observable<IUser> {
        return TODO()
//        return RxQuery.observable(userBox.query().build())
//                .map { entity ->
//                    entity.firstOrNull()?.let {
//                        User(it)
//                    }
//                }
    }

    override fun getUserAuthStateObservable(): Observable<Boolean> {
        return mAuthStateObservable
    }

    override fun refreshUserData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
