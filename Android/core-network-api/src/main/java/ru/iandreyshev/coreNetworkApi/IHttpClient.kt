package ru.iandreyshev.coreNetworkApi

interface IHttpClient {
    fun get(request: Request): Response
    fun apiGet(apiAuth: ApiAuth, request: Request): Response
}
