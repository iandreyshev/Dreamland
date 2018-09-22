package ru.iandreyshev.featureAccount.model.repository

interface IAccountRepository {

    val account: IAccount?

    fun signIn(loginData: IAuthProperties): IAccount
    fun signOut()

    companion object {
        fun builder() = Builder()
    }

}
