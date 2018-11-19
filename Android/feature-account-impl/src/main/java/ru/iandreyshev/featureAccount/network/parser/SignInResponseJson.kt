package ru.iandreyshev.featureAccount.network.parser

import com.google.gson.annotations.SerializedName

internal data class SignInResponseJson(
        @SerializedName("account")
        val account: AccountJson?,
        @SerializedName("error")
        val error: Error?
) {

    enum class Error {
        @SerializedName("0")
        USER_NOT_EXISTS,
        @SerializedName("1")
        INCORRECT_DATA
    }

}
