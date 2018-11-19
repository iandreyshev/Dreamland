package ru.iandreyshev.coreNetworkApi

data class ApiRequestOptions(
        val userId: Long? = null,
        val password: String? = null,
        val path: String? = null
)
