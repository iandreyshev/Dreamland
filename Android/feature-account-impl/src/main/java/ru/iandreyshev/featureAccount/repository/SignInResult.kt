package ru.iandreyshev.featureAccount.repository

enum class SignInResult {
    SUCCESS,
    USER_NOT_EXISTS,
    INCORRECT_DATA,
    NO_CONNECTION,
    UNKNOWN
}
