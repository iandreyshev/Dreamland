package ru.iandreyshev.featureDreams.network.response

class SaveResponse
private constructor(
        val result: Result?,
        val error: Error?
) {

    constructor(result: Result) : this(result, null)
    constructor(error: Error) : this(null, error)

    class Result(val id: Long)

    enum class Error {
        NO_CONNECTION,
        USER_NOT_EXISTS,
        INCORRECT_DATA,
        SERVER_ERROR
    }

}