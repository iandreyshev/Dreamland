package ru.iandreyshev.coreNetworkApi

data class Request(
        val path: String,
        val headers: Map<String, String>,
        val body: String
)
