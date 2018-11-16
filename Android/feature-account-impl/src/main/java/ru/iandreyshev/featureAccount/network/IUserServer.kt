package ru.iandreyshev.featureAccount.network

import ru.iandreyshev.featureAccount.network.request.DeleteRequest
import ru.iandreyshev.featureAccount.network.request.SignInRequest
import ru.iandreyshev.featureAccount.network.request.SignUpRequest
import ru.iandreyshev.featureAccount.network.response.DeleteResponse
import ru.iandreyshev.featureAccount.network.response.SignInResponse
import ru.iandreyshev.featureAccount.network.response.SignUpResponse

interface IUserServer {
    fun signIn(properties: SignInRequest): SignInResponse
    fun signUp(properties: SignUpRequest): SignUpResponse
    fun delete(properties: DeleteRequest): DeleteResponse
}
