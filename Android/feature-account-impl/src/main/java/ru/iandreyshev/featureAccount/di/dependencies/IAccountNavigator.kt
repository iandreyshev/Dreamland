package ru.iandreyshev.featureAccount.di.dependencies

interface IAccountNavigator {
    fun onSignInSuccess()
    fun onSignUpSuccess()
}
