package ru.iandreyshev.featureAccount.repository

enum class SignUpResult {
    SUCCESS,
    USER_ALREADY_EXISTS,
    NO_CONNECTION,
    UNKNOWN
}
