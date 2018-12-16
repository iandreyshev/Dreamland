package ru.iandreyshev.featureDreams.network.response

enum class EditResponse {
    SUCCESS,
    ERROR_NO_CONNECTION,
    USER_NOT_EXISTS,
    INCORRECT_DATA,
    ERROR_SERVER_ERROR
}