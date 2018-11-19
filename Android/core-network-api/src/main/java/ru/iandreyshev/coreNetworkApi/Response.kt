package ru.iandreyshev.coreNetworkApi

data class Response(
        val body: Body?,
        val error: Error?
) {

    constructor(body: Body) : this(body, null)
    constructor(error: Error) : this(null, error)

    class Body(
            val code: Int,
            val bodyString: String?
    )

    enum class Error {
        CONNECTION,
        PARSING,
        UNDEFINED;
    }

    val bodyString: String
        get() = body?.bodyString ?: ""

}
