package ru.iandreyshev.featureAccount.network.parser

import com.google.gson.annotations.SerializedName

class DeleteResponseJson(
        @SerializedName("error")
        val error: DeleteResponseJson.Error?
) {

    enum class Error {
        @SerializedName("user_not_exists")
        USER_NOT_EXISTS
    }

}
