package ru.iandreyshev.coreNetworkApi

data class Request(
        val path: String = "",
        val headers: Map<String, String> = mapOf(),
        val query: Map<String, String> = mapOf(),
        val body: String = ""
)
