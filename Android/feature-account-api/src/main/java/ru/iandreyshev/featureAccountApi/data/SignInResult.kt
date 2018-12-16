package ru.iandreyshev.featureAccountApi.data

enum class SignInResult {
    SUCCESS,
    ERROR_USER_NOT_EXISTS,
    ERROR_INCORRECT_EMAIL,
    ERROR_INCORRECT_PASSWORD,
    ERROR_INCORRECT_DATA,
    ERROR_NO_CONNECTION,
    ERROR_UNKNOWN
}
