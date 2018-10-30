package ru.iandreyshev.coreDatabase.impl

import io.reactivex.Observable
import ru.iandreyshev.coreDatabase.api.IUserDatabaseApi
import ru.iandreyshev.coreDatabase.entity.AccountEntity
import javax.inject.Inject

class UserDatabaseApiImpl
@Inject constructor() : IUserDatabaseApi {

    override val userObservable: Observable<AccountEntity>
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

}
