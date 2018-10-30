package ru.iandreyshev.coreNetworkApi.account.signUp

data class SignUpResponse(
        val accountGson: Account,
        val error: Error
) {

    data class Account(
            val id: Long
    )

    enum class Error

}
