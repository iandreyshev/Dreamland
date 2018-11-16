package ru.iandreyshev.coreNetworkApi

data class Response(
        val code: Int,
        val body: String?,
        val serverError: ServerError?
)
