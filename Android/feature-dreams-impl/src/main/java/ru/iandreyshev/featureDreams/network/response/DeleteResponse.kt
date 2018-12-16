package ru.iandreyshev.featureDreams.network.response

enum class DeleteResponse {
    SUCCESS,
    ERROR_NO_CONNECTION,
    ERROR_USER_NOT_EXISTS,
    ERROR_SERVER_ERROR
}
