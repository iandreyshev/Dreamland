package ru.iandreyshev.coreNetwork.account

import com.google.gson.Gson
import ru.iandreyshev.coreNetwork.account.gson.DeleteResponseGson
import ru.iandreyshev.coreNetwork.account.gson.SignInResponseGson
import ru.iandreyshev.coreNetwork.account.gson.SignUpResponseGson
import ru.iandreyshev.coreNetwork.httpClient.apiCall
import ru.iandreyshev.coreNetwork.httpClient.getRequestTo
import ru.iandreyshev.coreNetworkApi.account.IAccountNetworkApi
import ru.iandreyshev.coreNetworkApi.account.delete.DeleteRequest
import ru.iandreyshev.coreNetworkApi.account.delete.DeleteResponse
import ru.iandreyshev.coreNetworkApi.account.signIn.SignInRequest
import ru.iandreyshev.coreNetworkApi.account.signIn.SignInResponse
import ru.iandreyshev.coreNetworkApi.account.signUp.SignUpRequest
import ru.iandreyshev.coreNetworkApi.account.signUp.SignUpResponse
import javax.inject.Inject

internal class AccountNetworkApiImpl
@Inject constructor() : IAccountNetworkApi {

    companion object {
        private const val PATH_SIGN_IN = "account/sign_in"
        private const val PATH_SIGN_UP = "account/sign_up"
        private const val PATH_DELETE = "account/delete"
    }

    private val mGson = Gson()

    /**
     * Sign In
     **/
    override fun signIn(properties: SignInRequest): SignInResponse {
        val request = getRequestTo(PATH_SIGN_IN)
        val connError = SignInResponse(null, SignInResponse.Error.NO_CONNECTION)
        val serverError = SignInResponse(null, SignInResponse.Error.SERVER_ERROR)

        return apiCall(request, connError, serverError) { body ->
            mGson.fromJson(body, SignInResponseGson::class.java).toApiModel()
        }
    }

    /**
     * Sign Up
     **/
    override fun signUp(properties: SignUpRequest): SignUpResponse {
        val request = getRequestTo(PATH_SIGN_UP)
        val connError = SignUpResponse(null, SignUpResponse.Error.NO_CONNECTION)
        val serverError = SignUpResponse(null, SignUpResponse.Error.SERVER_ERROR)

        return apiCall(request, connError, serverError) { body ->
            mGson.fromJson(body, SignUpResponseGson::class.java).toApiModel()
        }
    }

    /**
     * Delete
     **/
    override fun delete(properties: DeleteRequest): DeleteResponse {
        val request = getRequestTo(PATH_DELETE)
        val connError = DeleteResponse(DeleteResponse.Result.NO_CONNECTION)
        val serverError = DeleteResponse(DeleteResponse.Result.SERVER_ERROR)

        return apiCall(request, connError, serverError) { body ->
            mGson.fromJson(body, DeleteResponseGson::class.java).toApiModel()
        }
    }

}
