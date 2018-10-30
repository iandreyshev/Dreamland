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
        private const val PATH_SIGN_IN = "account/signIn"
        private const val PATH_SIGN_UP = "account/signUp"
        private const val PATH_DELETE = "account/delete"
    }

    private val mGson = Gson()

    /**
     * Sign In
     **/
    override fun signIn(properties: SignInRequest): SignInResponse {
        val request = getRequestTo(PATH_SIGN_IN)
        val connError = SignInResponse(null, null)
        val serverError = SignInResponse(null, null)

        return apiCall(request, connError, serverError) { body ->
            mGson.fromJson(body, SignInResponseGson::class.java).transform()
        }
    }

    /**
     * Sign Up
     **/
    override fun signUp(properties: SignUpRequest): SignUpResponse {
        val request = getRequestTo(PATH_SIGN_UP)
        val connError = TODO()
        val serverError  = TODO()

        return apiCall(request, connError, serverError) { body ->
            mGson.fromJson(body, SignUpResponseGson::class.java).transform()
        }
    }

    /**
     * Delete
     **/
    override fun delete(properties: DeleteRequest): DeleteResponse {
        val request = getRequestTo(PATH_DELETE)
        val connError = TODO()
        val serverError  = TODO()

        return apiCall(request, connError, serverError) { body ->
            mGson.fromJson(body, DeleteResponseGson::class.java).transform()
        }
    }

}
