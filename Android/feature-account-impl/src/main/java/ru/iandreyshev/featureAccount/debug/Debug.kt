package ru.iandreyshev.featureAccount.debug

import ru.iandreyshev.featureAccount.BuildConfig
import ru.iandreyshev.featureAccount.network.request.SignInRequest
import ru.iandreyshev.featureAccount.network.response.SignInResponse

object Debug {

    object SignIn {
        fun request() = SignInRequest(
                login = "Tester",
                password = "123456"
        )

        fun account() = SignInResponse.Account(
                id = 1,
                fullName = "Tester Debugovich",
                avatarUrl = ""
        )
    }

    internal fun signInResponse(properties: SignInRequest): SignInResponse? =
            if (!BuildConfig.DEBUG) null
            else when (properties) {
                SignIn.request() -> SignInResponse(SignIn.account())
                else -> null
            }

}