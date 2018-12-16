package ru.iandreyshev.featureDreams.network.parser

import com.google.gson.annotations.SerializedName

class DeleteResponseJson(
        val error: DeleteResponseJson.Error?
) {

    enum class Error {
        @SerializedName("user_not_exists")
        USER_NOT_EXISTS,
        @SerializedName("undefined")
        UNDEFINED
    }

}