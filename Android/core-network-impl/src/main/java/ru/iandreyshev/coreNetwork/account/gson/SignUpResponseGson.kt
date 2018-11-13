package ru.iandreyshev.coreNetwork.account.gson

import com.google.gson.annotations.SerializedName
import ru.iandreyshev.coreNetworkApi.account.signUp.SignUpResponse

class SignUpResponseGson(
        @SerializedName("account")
        val account: AccountGson?,
        @SerializedName("error")
        val error: SignUpResponseGson.Error?
) {

    enum class Error {
        @SerializedName("0")
        USER_NOT_EXISTS,
        @SerializedName("1")
        INCORRECT_DATA
    }

    fun toApiModel(): SignUpResponse {
        if (account != null) {
            return SignUpResponse(
                    SignUpResponse.Account(account.id, account.fullName, account.avatarUrl)
            )
        }

        return SignUpResponse(when (error) {
            SignUpResponseGson.Error.USER_NOT_EXISTS -> SignUpResponse.Error.USER_ALREADY_EXISTS
            SignUpResponseGson.Error.INCORRECT_DATA -> SignUpResponse.Error.INCORRECT_DATA
            null -> SignUpResponse.Error.SERVER_ERROR
        })
    }

}
