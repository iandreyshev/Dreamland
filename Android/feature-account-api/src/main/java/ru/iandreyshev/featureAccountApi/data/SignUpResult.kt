package ru.iandreyshev.featureAccountApi.data

enum class SignUpResult {
    SUCCESS,
    USER_ALREADY_EXISTS,
    INCORRECT_DATA,
    NO_CONNECTION,
    UNKNOWN
}
