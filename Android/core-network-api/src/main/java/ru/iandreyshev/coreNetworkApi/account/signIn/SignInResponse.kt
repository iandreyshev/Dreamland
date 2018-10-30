package ru.iandreyshev.coreNetworkApi.account.signIn

data class SignInResponse(
        val account: Account?,
        val error: Error?
) {

    data class Account(
            val id: Long
    )

    enum class Error

}
