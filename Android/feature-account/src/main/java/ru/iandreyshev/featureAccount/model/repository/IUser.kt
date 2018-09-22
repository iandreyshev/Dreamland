package ru.iandreyshev.featureAccount.model.repository

interface IUser {
    val isSignIn: Boolean
    val account: IAccount?
}
