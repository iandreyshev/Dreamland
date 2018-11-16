package ru.iandreyshev.featureAccount.network.request

data class SignUpRequest(
        val email: String,
        val fullName: String,
        val password: String
)
