package ru.iandreyshev.coreNetworkApi.account

import ru.iandreyshev.coreNetworkApi.account.delete.DeleteRequest
import ru.iandreyshev.coreNetworkApi.account.delete.DeleteResponse
import ru.iandreyshev.coreNetworkApi.account.signIn.SignInRequest
import ru.iandreyshev.coreNetworkApi.account.signIn.SignInResponse
import ru.iandreyshev.coreNetworkApi.account.signUp.SignUpRequest
import ru.iandreyshev.coreNetworkApi.account.signUp.SignUpResponse

interface IAccountNetworkApi {
    fun signIn(properties: SignInRequest): SignInResponse
    fun signUp(properties: SignUpRequest): SignUpResponse
    fun delete(properties: DeleteRequest): DeleteResponse
}
