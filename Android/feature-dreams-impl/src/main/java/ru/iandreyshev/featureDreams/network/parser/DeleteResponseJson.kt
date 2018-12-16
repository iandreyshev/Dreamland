package ru.iandreyshev.featureDreams.network.parser

import com.google.gson.annotations.SerializedName

class DeleteResponseJson(
        val error: DeleteResponseJson.Error?
) {

    enum class Error {
        @SerializedName("0")
        USER_NOT_EXISTS
    }

}