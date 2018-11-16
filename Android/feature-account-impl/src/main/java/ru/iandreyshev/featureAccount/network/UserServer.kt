package ru.iandreyshev.featureAccount.network

import com.google.gson.Gson
import ru.iandreyshev.featureAccount.network.request.DeleteRequest
import ru.iandreyshev.featureAccount.network.response.DeleteResponse
import ru.iandreyshev.featureAccount.network.request.SignInRequest
import ru.iandreyshev.featureAccount.network.response.SignInResponse
import ru.iandreyshev.featureAccount.network.request.SignUpRequest
import ru.iandreyshev.featureAccount.network.response.SignUpResponse
import javax.inject.Inject

class UserServer
@Inject constructor(
) : IUserServer {

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
//        val request = getRequestTo(PATH_SIGN_IN)
//        val connError = SignInResponse(null, SignInResponse.Error.NO_CONNECTION)
//        val serverError = SignInResponse(null, SignInResponse.Error.SERVER_ERROR)
//
//        return apiCall(request, connError, serverError) { body ->
//            mGson.fromJson(body, SignInResponseGson::class.java).toApiModel()
//        }
        return SignInResponse(SignInResponse.Error.SERVER_ERROR)
    }

    /**
     * Sign Up
     **/
    override fun signUp(properties: SignUpRequest): SignUpResponse {
//        val request = getRequestTo(PATH_SIGN_UP)
//        val connError = SignUpResponse(null, SignUpResponse.Error.NO_CONNECTION)
//        val serverError = SignUpResponse(null, SignUpResponse.Error.SERVER_ERROR)
//
//        return apiCall(request, connError, serverError) { body ->
//            mGson.fromJson(body, SignUpResponseGson::class.java).toApiModel()
//        }
        return SignUpResponse(SignUpResponse.Error.SERVER_ERROR)
    }


    /**
     * Delete
     **/
    override fun delete(properties: DeleteRequest): DeleteResponse {
//        val request = getRequestTo(PATH_DELETE)
//        val connError = DeleteResponse(DeleteResponse.Result.NO_CONNECTION)
//        val serverError = DeleteResponse(DeleteResponse.Result.SERVER_ERROR)
//
//        return apiCall(request, connError, serverError) { body ->
//            mGson.fromJson(body, DeleteResponseGson::class.java).toApiModel()
//        }
        return TODO()
    }

}
