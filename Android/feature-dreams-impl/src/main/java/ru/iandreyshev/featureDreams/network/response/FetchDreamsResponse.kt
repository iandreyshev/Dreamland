package ru.iandreyshev.featureDreams.network.response

import ru.iandreyshev.featureDreams.network.parser.DreamJson

class FetchDreamsResponse
private constructor(
        val result: Result?,
        val error: Error?
) {

    constructor(result: Result) : this(result, null)
    constructor(error: Error) : this(null, error)

    data class Result(val dreams: List<DreamJson>)

    enum class Error {
        NO_CONNECTION,
        SERVER_ERROR
    }

}