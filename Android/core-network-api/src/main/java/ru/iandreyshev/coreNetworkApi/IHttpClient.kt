package ru.iandreyshev.coreNetworkApi

interface IHttpClient {
    fun get(request: Request): Response
    fun post(request: Request): Response
    fun delete(request: Request): Response
}
