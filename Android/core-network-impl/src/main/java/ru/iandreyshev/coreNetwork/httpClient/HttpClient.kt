package ru.iandreyshev.coreNetwork.httpClient

import com.facebook.stetho.Stetho
import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.Headers
import okhttp3.OkHttpClient
import ru.iandreyshev.coreNetwork.di.dependencies.IContextProvider
import ru.iandreyshev.coreNetwork.extension.applyOptions
import ru.iandreyshev.coreNetwork.extension.toApplicationResponse
import ru.iandreyshev.coreNetwork.extension.uriString
import ru.iandreyshev.coreNetworkApi.data.ApiRequestOptions
import ru.iandreyshev.coreNetworkApi.api.IHttpClient
import ru.iandreyshev.coreNetworkApi.data.Request
import ru.iandreyshev.coreNetworkApi.data.Response
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
            .url(request.uriString)
            .headers(Headers.of(request.headers))
            .build()
            .call(::toApplicationResponse)

    override fun get(request: Request, options: ApiRequestOptions): Response =
            request.applyOptions(options).let(::get)

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

}
