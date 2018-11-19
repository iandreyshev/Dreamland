package ru.iandreyshev.featureAccount.network

import ru.iandreyshev.featureAccount.network.request.DeleteRequest
import ru.iandreyshev.featureAccount.network.request.SignInRequest
import ru.iandreyshev.featureAccount.network.request.SignUpRequest
import ru.iandreyshev.featureAccount.network.response.DeleteResponse
import ru.iandreyshev.featureAccount.network.response.SignInResponse
import ru.iandreyshev.featureAccount.network.response.SignUpResponse

interface IUserServerApi {
    fun signIn(request: SignInRequest): SignInResponse
    fun signUp(request: SignUpRequest): SignUpResponse
    fun delete(request: DeleteRequest): DeleteResponse
}
