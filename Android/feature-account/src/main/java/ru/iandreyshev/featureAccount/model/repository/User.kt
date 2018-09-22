package ru.iandreyshev.featureAccount.model.repository

internal data class User(
        override val account: IAccount? = null
) : IUser {

    override val isSignIn = account != null

}
