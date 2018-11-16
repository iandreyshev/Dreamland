package ru.iandreyshev.coreNetwork.httpClient

import ru.iandreyshev.coreNetworkApi.IHttpClient
import ru.iandreyshev.coreNetworkApi.Request
import javax.inject.Inject

class HttpClient
@Inject constructor(

) : IHttpClient {

    override fun get(request: Request) = HttpGet().invoke(request)
    override fun post(request: Request) = HttpPost().invoke(request)
    override fun delete(request: Request) = HttpDelete().invoke(request)

}
