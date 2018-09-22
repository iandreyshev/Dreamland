package ru.iandreyshev.featureAccount.model.repository

import android.content.Context
import ru.iandreyshev.featureAccount.model.storage.AccountEntity
import ru.iandreyshev.featureAccount.model.storage.MyObjectBox

internal class AccountRepository(context: Context) : IAccountRepository {

    private val mBoxStore by lazy {
        MyObjectBox.builder().androidContext(context).build()
    }

    private val mAccountBox by lazy {
        mBoxStore.boxFor(AccountEntity::class.java)
    }

    override val account: IAccount?
        get() = null

    override fun signIn(loginData: IAuthProperties): IAccount {
        TODO("signIn not implemented")
    }

    override fun signOut() {
        TODO("signOut not implemented")
    }

}
