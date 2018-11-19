package ru.iandreyshev.coreNetworkApi

interface IHttpClient {
    fun get(request: Request): Response
    fun get(request: Request, options: ApiRequestOptions): Response

    fun delete(request: Request): Response
    fun delete(request: Request, options: ApiRequestOptions): Response
}
