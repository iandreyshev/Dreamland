package ru.iandreyshev.coreNetwork.account.gson

import com.google.gson.annotations.SerializedName
import ru.iandreyshev.coreNetworkApi.account.signIn.SignInResponse

internal data class SignInResponseGson(
        @SerializedName("account")
        val account: AccountGson?,
        @SerializedName("error")
        val error: ErrorGson?
) {

    enum class ErrorGson {
        @SerializedName("0")
        ERROR_0,
        @SerializedName("1")
        ERROR_1
    }

    fun transform(): SignInResponse {
        return TODO()
    }

}
