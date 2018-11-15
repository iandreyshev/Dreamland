package ru.iandreyshev.coreNetwork.httpClient

import okhttp3.*
import ru.iandreyshev.coreNetworkApi.UserIdentifier
import java.io.IOException
import java.lang.Exception
import java.lang.IllegalStateException

private val HTTP_CLIENT = OkHttpClient()

private const val MOBILE_API_URL = ""

private const val HEADER_CONTENT_TYPE = ""
private const val HEADER_ACCOUNT_ID = ""
private const val HEADER_PASSWORD = ""

private const val RESPONSE_CODE_SUCCESS = 200
private const val RESPONSE_CODE_ERROR = 500

internal val UserIdentifier.headers: Headers
    get() = Headers.of(mapOf(
            HEADER_ACCOUNT_ID to id.toString(),
            HEADER_PASSWORD to password
    ))

internal fun getRequestTo(path: String): Request =
        Request.Builder()
                .get()
                .url(MOBILE_API_URL + path)
                .build()

internal fun getRequestTo(path: String, account: UserIdentifier): Request =
        Request.Builder()
                .get()
                .url(MOBILE_API_URL + path)
                .headers(account.headers)
                .build()

fun <T> apiCall(request: Request, connError: T, serverError: T, onSuccess: (String) -> T): T {
    return try {

        val response = HTTP_CLIENT.newCall(request).execute()
        val bodyStr = response.body()?.string()
                ?: throw IllegalStateException("Body is null")

        onSuccess.invoke(bodyStr)

    } catch (ex: IOException) {

        ex.printStackTrace()
        connError

    } catch (ex: Exception) {

        ex.printStackTrace()
        serverError

    }
}
