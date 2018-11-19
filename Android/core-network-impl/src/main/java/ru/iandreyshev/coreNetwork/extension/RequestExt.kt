package ru.iandreyshev.coreNetwork.extension

import android.net.Uri
import ru.iandreyshev.coreNetwork.httpClient.HEADER_ACCOUNT_ID
import ru.iandreyshev.coreNetwork.httpClient.HEADER_PASSWORD
import ru.iandreyshev.coreNetwork.httpClient.MOBILE_API_URL
import ru.iandreyshev.coreNetworkApi.ApiRequestOptions
import ru.iandreyshev.coreNetworkApi.Request

fun Request.applyOptions(options: ApiRequestOptions): Request {
    return Request(
            path = MOBILE_API_URL + options.path,
            headers = headers + options.headers,
            query = query,
            body = body
    )
}

val Request.uriString: String
    get() {
        val builder = Uri.parse(path).buildUpon()

        query.forEach {
            builder.appendQueryParameter(it.key, it.value)
        }

        return builder.build().toString()
    }

private val ApiRequestOptions.headers: Map<String, String>
    get() {
        val headersMap = mutableMapOf<String, String>()

        userId?.let {
            headersMap.put(HEADER_ACCOUNT_ID, userId.toString())
        }

        password?.let {
            HEADER_PASSWORD to password
        }

        return headersMap
    }


