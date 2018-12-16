package ru.iandreyshev.featureAccount.network.parser

import com.google.gson.annotations.SerializedName

class SignUpResponseJson(
        @SerializedName("account")
        val account: AccountJson?,
        @SerializedName("error")
        val error: SignUpResponseJson.Error?
) {

    enum class Error {
        @SerializedName("already_exists")
        USER_ALREADY_EXISTS,
        @SerializedName("incorrect_data")
        INCORRECT_DATA
    }

}
