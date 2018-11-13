package ru.iandreyshev.coreDatabase.impl

import io.objectbox.BoxStore
import io.objectbox.rx.RxQuery
import io.reactivex.Observable
import ru.iandreyshev.coreDatabase.entity.AccountDatabaseEntity
import ru.iandreyshev.coreDatabase.entity.toApiEntity
import ru.iandreyshev.coreDatabase.entity.toDatabaseEntity
import ru.iandreyshev.coreDatabaseApi.account.IAccountDatabaseApi
import ru.iandreyshev.coreDatabaseApi.account.AccountEntity
import javax.inject.Inject

class AccountDatabaseApiImpl
@Inject constructor(
        boxStore: BoxStore
) : IAccountDatabaseApi {

    private val mDatabase = boxStore.boxFor(AccountDatabaseEntity::class.java)
    private val mUserObservable = RxQuery.observable(mDatabase.query().build())
            .map { it.firstOrNull() }
            .map { it.toApiEntity() }

    override val userObservable: Observable<AccountEntity?>
        get() = mUserObservable

    override val isUserExists: Boolean
        get() = mDatabase.count() > 0

    override fun setUser(entity: AccountEntity) {
        mDatabase.removeAll()
        mDatabase.put(entity.toDatabaseEntity())
    }

    override fun getUser(): AccountEntity? =
            mDatabase.all.firstOrNull()?.toApiEntity()

}
