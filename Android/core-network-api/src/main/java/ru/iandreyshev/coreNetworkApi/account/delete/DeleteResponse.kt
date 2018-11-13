package ru.iandreyshev.coreNetworkApi.account.delete

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
