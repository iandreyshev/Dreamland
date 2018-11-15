package ru.iandreyshev.featureAccountApi.data

enum class SignInResult {
    SUCCESS,
    USER_NOT_EXISTS,
    INCORRECT_DATA,
    NO_CONNECTION,
    UNKNOWN
}
