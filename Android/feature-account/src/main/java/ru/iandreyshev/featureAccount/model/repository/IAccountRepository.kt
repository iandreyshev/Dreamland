package ru.iandreyshev.featureAccount.model.repository

import android.content.Context
import ru.iandreyshev.featureAccount.model.account.IAuthProperties
import ru.iandreyshev.featureAccount.model.account.IUserAccount

interface IAccountRepository {

    val account: IUserAccount?

    fun signIn(loginData: IAuthProperties): IUserAccount
    fun signOut()

    companion object {
        fun newRepository(context: Context): IAccountRepository =
                AccountRepository(context)
    }

}
