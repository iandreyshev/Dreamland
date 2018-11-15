package ru.iandreyshev.featureAccount.repository

import io.reactivex.*
import ru.iandreyshev.coreAndroid.rx.ioToMain
import ru.iandreyshev.featureAccountApi.data.User

class UserRepository : IUserRepository {

    override val userObservable: Observable<User>
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override fun logout(): Completable {
        return Completable.fromCallable {
            Thread.sleep(500)
        }.ioToMain()
    }

}
