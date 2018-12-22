package ru.iandreyshev.coreNetwork.httpClient

import com.facebook.stetho.Stetho
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.*
import ru.iandreyshev.coreAndroid.di.context.IContextProvider
import ru.iandreyshev.coreNetwork.extension.applyOptions
import ru.iandreyshev.coreNetwork.extension.toApplicationResponse
import ru.iandreyshev.coreNetwork.extension.uriString
import ru.iandreyshev.coreNetworkApi.data.ApiRequestOptions
import ru.iandreyshev.coreNetworkApi.api.IHttpClient
import ru.iandreyshev.coreNetworkApi.data.Request
import ru.iandreyshev.coreNetworkApi.data.Response
import java.io.IOException
import java.lang.Exception
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class HttpClient
@Inject constructor(
        contextProvider: IContextProvider
) : IHttpClient {

    private val mOkHttpClient: OkHttpClient = OkHttpClient.Builder()
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS)
            .addNetworkInterceptor(StethoInterceptor())
            .build()

    init {
        Stetho.initializeWithDefaults(contextProvider.context)
    }

    override fun get(request: Request): Response = okhttp3.Request.Builder()
            .get()
            .url(request.uriString)
            .headers(Headers.of(request.headers))
            .build()
            .call(::toApplicationResponse)

    override fun get(request: Request, options: ApiRequestOptions): Response =
            request.applyOptions(options).let(::get)

    override fun post(request: Request): Response = okhttp3.Request.Builder()
            .post(RequestBody.create(JSON, request.body))
            .url(request.uriString)
            .headers(Headers.of(request.headers))
            .build()
            .call(::toApplicationResponse)

    override fun post(request: Request, options: ApiRequestOptions): Response =
            request.applyOptions(options).let(::post)

    override fun delete(request: Request): Response = okhttp3.Request.Builder()
            .delete()
            .url(request.uriString)
            .headers(Headers.of(request.headers))
            .build()
            .call(::toApplicationResponse)

    override fun delete(request: Request, options: ApiRequestOptions): Response =
            request.applyOptions(options).let(::delete)

    private fun okhttp3.Request.call(onSuccess: (okhttp3.Response) -> Response): Response {
        val response: okhttp3.Response

        try {
            response = mOkHttpClient.newCall(this).execute()

            if (!response.isSuccessful) {
                return Response(Response.Error.UNDEFINED)
            }
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

    companion object {
        private val JSON = MediaType.parse("application/json; charset=utf-8")
    }

}
