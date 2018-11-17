package ru.iandreyshev.coreNetwork.httpClient

import com.facebook.stetho.Stetho
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.Headers
import okhttp3.OkHttpClient
import ru.iandreyshev.coreNetwork.di.dependencies.IContextProvider
import ru.iandreyshev.coreNetwork.extension.headers
import ru.iandreyshev.coreNetworkApi.ApiAuth
import ru.iandreyshev.coreNetworkApi.IHttpClient
import ru.iandreyshev.coreNetworkApi.Request
import ru.iandreyshev.coreNetworkApi.Response
import java.io.IOException
import java.lang.Exception
import javax.inject.Inject

class HttpClient
@Inject constructor(
        contextProvider: IContextProvider
) : IHttpClient {

    init {
        Stetho.initializeWithDefaults(contextProvider.applicationContext)
    }

    private val mOkHttpClient: OkHttpClient = OkHttpClient.Builder()
            .addNetworkInterceptor(StethoInterceptor())
            .build()

    override fun get(request: Request): Response = okhttp3.Request.Builder()
            .get()
            .url(request.path)
            .headers(Headers.of(request.headers))
            .build()
            .call { okHttpResponse ->
                Response(Response.Body(
                        code = okHttpResponse.code(),
                        body = okHttpResponse.body()?.bytes() ?: byteArrayOf()))
            }

    override fun apiGet(apiAuth: ApiAuth, request: Request): Response {
        val apiRequest = request.copy(
                path = MOBILE_API_URL + request.path,
                headers = request.headers + apiAuth.headers
        )

        return get(apiRequest)
    }

    private fun okhttp3.Request.call(onSuccess: (okhttp3.Response) -> Response): Response {
        val response: okhttp3.Response

        try {
            response = mOkHttpClient.newCall(this).execute()
        } catch (ex: IOException) {
            ex.printStackTrace()
            return Response(Response.Error.CONNECTION)
        } catch (ex: Exception) {
            ex.printStackTrace()
            return Response(Response.Error.UNDEFINED)
        }

        return try {
            onSuccess(response)
        } catch (ex: Exception) {
            Response(Response.Error.PARSING)
        }
    }

}
