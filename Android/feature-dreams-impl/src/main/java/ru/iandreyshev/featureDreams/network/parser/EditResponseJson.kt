package ru.iandreyshev.featureDreams.network.parser

import com.google.gson.annotations.SerializedName

class EditResponseJson(
        @SerializedName("error")
        val error: EditResponseJson.Error?
) {

    enum class Error {
        @SerializedName("0")
        USER_NOT_EXISTS
    }

}