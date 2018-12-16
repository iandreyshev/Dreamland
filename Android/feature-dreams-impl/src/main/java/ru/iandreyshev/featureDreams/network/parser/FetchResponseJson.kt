package ru.iandreyshev.featureDreams.network.parser

import com.google.gson.annotations.SerializedName

data class FetchResponseJson(
        @SerializedName("dreams")
        val dreams: List<DreamJson>?,
        @SerializedName("error")
        val error: FetchResponseJson.Error?
) {

    enum class Error {
        @SerializedName("0")
        USER_NOT_EXISTS
    }

}