package ru.iandreyshev.featureAccount.network.parser

import com.google.gson.annotations.SerializedName

class DeleteResponseJson(
        @SerializedName("error")
        val error: DeleteResponseJson.Error?
) {

    enum class Error {
        @SerializedName("0")
        USER_NOT_EXISTS
    }

}
