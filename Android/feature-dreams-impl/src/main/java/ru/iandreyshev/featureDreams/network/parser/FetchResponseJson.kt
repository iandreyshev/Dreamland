package ru.iandreyshev.featureDreams.network.parser

import com.google.gson.annotations.SerializedName

data class FetchResponseJson(
        @SerializedName("dreams")
        val dreams: List<DreamJson>?,
        @SerializedName("error")
        val error: FetchResponseJson.Error?
) {

    enum class Error {
        @SerializedName("user_not_exists")
        USER_NOT_EXISTS,
        @SerializedName("undefined")
        UNDEFINED
    }

}