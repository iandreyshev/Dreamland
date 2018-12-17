package ru.iandreyshev.featureAccount.network.parser

import com.google.gson.annotations.SerializedName

internal data class SignInResponseJson(
        @SerializedName("account")
        val account: AccountJson?,
        @SerializedName("error")
        val error: Error?
) {

    enum class Error {
        @SerializedName("user_not_exists")
        USER_NOT_EXISTS,
        @SerializedName("incorrect_data")
        INCORRECT_DATA
    }

}
