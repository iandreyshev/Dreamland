package ru.iandreyshev.featureAccount.network.request

data class SignInRequest(
        val login: String,
        val password: String
)
