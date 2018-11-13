package ru.iandreyshev.featureAccountApi.repository

enum class SignUpResult {
    SUCCESS,
    USER_ALREADY_EXISTS,
    NO_CONNECTION,
    UNKNOWN
}
