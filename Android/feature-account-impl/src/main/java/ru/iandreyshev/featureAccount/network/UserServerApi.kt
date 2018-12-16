package ru.iandreyshev.featureAccount.network

import com.google.gson.Gson
import ru.iandreyshev.coreNetworkApi.data.ApiRequestOptions
import ru.iandreyshev.coreNetworkApi.api.IHttpClient
import ru.iandreyshev.coreNetworkApi.data.Request
import ru.iandreyshev.coreNetworkApi.data.Response
import ru.iandreyshev.featureAccount.debug.Debug
import ru.iandreyshev.featureAccount.mapping.toApplicationModel
import ru.iandreyshev.featureAccount.network.parser.DeleteResponseJson
import ru.iandreyshev.featureAccount.network.parser.SignInResponseJson
import ru.iandreyshev.featureAccount.network.parser.SignUpResponseJson
import ru.iandreyshev.featureAccount.network.request.DeleteRequest
import ru.iandreyshev.featureAccount.network.response.DeleteResponse
import ru.iandreyshev.featureAccount.network.request.SignInRequest
import ru.iandreyshev.featureAccount.network.response.SignInResponse
import ru.iandreyshev.featureAccount.network.request.SignUpRequest
import ru.iandreyshev.featureAccount.network.response.SignUpResponse
import javax.inject.Inject

class UserServerApi
@Inject constructor(
        private val httpClient: IHttpClient
) : IUserServerApi {

    private val mJsonParser = Gson()

    override fun signIn(request: SignInRequest): SignInResponse {
        Debug.signInResponse(request)?.let { return it }

        val apiRequest = Request(query = mapOf(
                QUERY_EMAIL to request.login,
                QUERY_PASSWORD to request.password)
        )
        val apiOptions = ApiRequestOptions(path = PATH_SIGN_IN)
        val apiResponse = httpClient.get(apiRequest, apiOptions)

        when (apiResponse.error) {
            Response.Error.CONNECTION ->
                return SignInResponse(SignInResponse.Error.NO_CONNECTION)
            Response.Error.PARSING,
            Response.Error.UNDEFINED ->
                return SignInResponse(SignInResponse.Error.SERVER_ERROR)
        }

        return mJsonParser
                .fromJson(apiResponse.bodyString, SignInResponseJson::class.java)
                .toApplicationModel()
    }

    override fun signUp(request: SignUpRequest): SignUpResponse {
        val apiRequest = Request(query = mapOf(
                QUERY_EMAIL to request.email,
                QUERY_PASSWORD to request.password,
                QUERY_NAME to request.fullName)
        )
        val apiOptions = ApiRequestOptions(path = PATH_SIGN_UP)
        val apiResponse = httpClient.get(apiRequest, apiOptions)

        when (apiResponse.error) {
            Response.Error.CONNECTION ->
                return SignUpResponse(SignUpResponse.Error.NO_CONNECTION)
            Response.Error.PARSING,
            Response.Error.UNDEFINED ->
                return SignUpResponse(SignUpResponse.Error.SERVER_ERROR)
        }

        return mJsonParser
                .fromJson(apiResponse.bodyString, SignUpResponseJson::class.java)
                .toApplicationModel()
    }

    override fun delete(request: DeleteRequest): DeleteResponse {
        val apiRequest = Request(query = mapOf(
                QUERY_ID to request.id.toString(),
                QUERY_PASSWORD to request.password)
        )
        val apiOptions = ApiRequestOptions(path = PATH_DELETE)
        val apiResponse = httpClient.delete(apiRequest, apiOptions)

        when (apiResponse.error) {
            Response.Error.CONNECTION ->
                return DeleteResponse.NO_CONNECTION
            Response.Error.PARSING,
            Response.Error.UNDEFINED ->
                return DeleteResponse.SERVER_ERROR
        }

        return mJsonParser
                .fromJson(apiResponse.bodyString, DeleteResponseJson::class.java)
                .toApplicationModel()
    }

    companion object {
        private const val PATH_SIGN_IN = "/account/sign_in"
        private const val PATH_SIGN_UP = "/account/sign_up"
        private const val PATH_DELETE = "/account/delete"

        private const val QUERY_EMAIL = "email"
        private const val QUERY_PASSWORD = "password"
        private const val QUERY_NAME = "name"
        private const val QUERY_ID = "id"
    }

}
