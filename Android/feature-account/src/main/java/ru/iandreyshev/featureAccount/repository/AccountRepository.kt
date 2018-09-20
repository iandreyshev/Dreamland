package ru.iandreyshev.featureAccount.repository

import android.content.Context
import ru.iandreyshev.featureAccount.account.IAuthProperties
import ru.iandreyshev.featureAccount.account.IUserAccount
import ru.iandreyshev.featureAccount.storage.MyObjectBox

internal class AccountRepository(
        private val context: Context
) : IAccountRepository {

    private val mBoxStore = MyObjectBox.builder()
            .androidContext(context)
            .build()

    override val account: IUserAccount?
        get() = null

    override fun signIn(loginData: IAuthProperties): IUserAccount {
        TODO("signIn not implemented")
    }

    override fun signOut() {
        TODO("signOut not implemented")
    }

}
