package ru.iandreyshev.coreNetworkApi

data class Response(
        val body: Body?,
        val error: Error?
) {

    constructor(body: Body) : this(body, null)
    constructor(error: Error) : this(null, error)

    class Body(
            val code: Int,
            val body: ByteArray
    )

    enum class Error {
        CONNECTION,
        PARSING,
        UNDEFINED;
    }

}
