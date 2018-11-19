package ru.iandreyshev.coreNetwork.extension

import okhttp3.Response

fun toApplicationResponse(response: Response): ru.iandreyshev.coreNetworkApi.Response {
    val code = response.code()
    val bodyString = response.body()?.string()
    val body = ru.iandreyshev.coreNetworkApi.Response.Body(code, bodyString)
    return ru.iandreyshev.coreNetworkApi.Response(body)
}