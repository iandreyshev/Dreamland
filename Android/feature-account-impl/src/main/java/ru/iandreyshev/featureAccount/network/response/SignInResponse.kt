package ru.iandreyshev.featureAccount.network.response

data class SignInResponse(
        val account: Account?,
        val error: Error?
) {

    constructor(account: Account) : this(account, null)
    constructor(error: Error) : this(null, error)

    data class Account(
            val id: Long,
            val fullName: String,
            val avatarUrl: String?
    )

    enum class Error {
        USER_NOT_EXISTS,
        INCORRECT_DATA,
        NO_CONNECTION,
        SERVER_ERROR
    }

}
