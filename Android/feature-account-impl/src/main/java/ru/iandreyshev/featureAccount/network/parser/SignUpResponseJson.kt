package ru.iandreyshev.featureAccount.network.parser

import com.google.gson.annotations.SerializedName

class SignUpResponseJson(
        @SerializedName("account")
        val account: AccountJson?,
        @SerializedName("error")
        val error: SignUpResponseJson.Error?
) {

    enum class Error {
        @SerializedName("0")
        USER_ALREADY_EXISTS,
        @SerializedName("1")
        INCORRECT_DATA
    }

}
