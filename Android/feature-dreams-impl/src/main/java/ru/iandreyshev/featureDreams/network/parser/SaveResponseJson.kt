package ru.iandreyshev.featureDreams.network.parser

import com.google.gson.annotations.SerializedName

class SaveResponseJson(
        @SerializedName("dream_id")
        val dreamId: Long?,
        @SerializedName("error")
        val error: SaveResponseJson.Error?
) {

    enum class Error {
        @SerializedName("0")
        USER_NOT_EXISTS
    }

}
