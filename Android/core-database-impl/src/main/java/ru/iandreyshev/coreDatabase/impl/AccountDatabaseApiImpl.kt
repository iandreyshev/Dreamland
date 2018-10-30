package ru.iandreyshev.coreDatabase.impl

import io.reactivex.Observable
import ru.iandreyshev.coreDatabaseApi.account.IAccountDatabaseApi
import ru.iandreyshev.coreDatabaseApi.account.AccountEntity
import javax.inject.Inject

class AccountDatabaseApiImpl
@Inject constructor() : IAccountDatabaseApi {

    override val userObservable: Observable<AccountEntity>
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

}
