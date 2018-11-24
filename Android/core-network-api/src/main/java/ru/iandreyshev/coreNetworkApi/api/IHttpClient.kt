package ru.iandreyshev.coreNetworkApi.api

import ru.iandreyshev.coreNetworkApi.data.ApiRequestOptions
import ru.iandreyshev.coreNetworkApi.data.Request
import ru.iandreyshev.coreNetworkApi.data.Response

interface IHttpClient {
    fun get(request: Request): Response
    fun get(request: Request, options: ApiRequestOptions): Response

    fun delete(request: Request): Response
    fun delete(request: Request, options: ApiRequestOptions): Response
}
