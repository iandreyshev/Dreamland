package ru.iandreyshev.coreNetwork.account.gson

import com.google.gson.annotations.SerializedName
import ru.iandreyshev.coreNetworkApi.account.signIn.SignInResponse

internal data class SignInResponseGson(
        @SerializedName("account")
        val account: AccountGson?,
        @SerializedName("error")
        val error: Error?
) {

    enum class Error {
        @SerializedName("0")
        USER_NOT_EXISTS,
        @SerializedName("1")
        INCORRECT_DATA
    }

    fun toApiModel(): SignInResponse {
        if (account != null) {
            return SignInResponse(
                    SignInResponse.Account(account.id, account.fullName, account.avatarUrl)
            )
        }

        return SignInResponse(when (error) {
            Error.USER_NOT_EXISTS -> SignInResponse.Error.USER_NOT_EXISTS
            Error.INCORRECT_DATA -> SignInResponse.Error.INCORRECT_DATA
            else -> SignInResponse.Error.SERVER_ERROR
        })
    }

}
