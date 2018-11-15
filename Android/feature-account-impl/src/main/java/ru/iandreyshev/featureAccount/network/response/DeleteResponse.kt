package ru.iandreyshev.featureAccount.network.response

class DeleteResponse(
        val result: Result
) {

    enum class Result {
        SUCCESS,
        USER_NOT_EXISTS,
        NO_ACCESS,
        NO_CONNECTION,
        SERVER_ERROR
    }

}
