package ru.iandreyshev.coreNetwork.extension

import android.net.Uri
import ru.iandreyshev.coreNetwork.httpClient.HEADER_ACCOUNT_ID
import ru.iandreyshev.coreNetwork.httpClient.HEADER_ACCOUNT_PASSWORD
import ru.iandreyshev.coreNetwork.httpClient.MOBILE_API_URL
import ru.iandreyshev.coreNetworkApi.data.ApiRequestOptions
import ru.iandreyshev.coreNetworkApi.data.Request

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

        userId?.run {
            headersMap[HEADER_ACCOUNT_ID] = toString()
        }
        password?.run {
            headersMap[HEADER_ACCOUNT_PASSWORD] = this
        }

        return headersMap
    }


