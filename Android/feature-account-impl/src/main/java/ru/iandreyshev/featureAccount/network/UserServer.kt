package ru.iandreyshev.featureAccount.network

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

        private const val MAIL = "email"
        private const val NAME = "Ivan"
        private const val PASS = "pass"
    }

    override fun signIn(properties: SignInRequest): SignInResponse {
        if (properties.login != NAME) {
            return SignInResponse(SignInResponse.Error.USER_NOT_EXISTS)
        }

        if (properties.password != PASS) {
            return SignInResponse(SignInResponse.Error.USER_NOT_EXISTS)
        }

        return SignInResponse(SignInResponse.Account(
                id = 0,
                fullName = NAME,
                avatarUrl = ""
        ))
    }

    override fun signUp(properties: SignUpRequest): SignUpResponse {
        if (properties.email != MAIL) {
            return SignUpResponse(SignUpResponse.Error.USER_ALREADY_EXISTS)
        }

        if (properties.password != PASS) {
            return SignUpResponse(SignUpResponse.Error.USER_ALREADY_EXISTS)
        }
        
        if (properties.fullName.isEmpty()) {
            return SignUpResponse(SignUpResponse.Error.INCORRECT_DATA)
        }

        return SignUpResponse(SignUpResponse.Account(
                id = 0,
                fullName = properties.fullName,
                avatarUrl = ""
        ))
    }

    override fun delete(properties: DeleteRequest): DeleteResponse {
        return TODO()
    }

}
