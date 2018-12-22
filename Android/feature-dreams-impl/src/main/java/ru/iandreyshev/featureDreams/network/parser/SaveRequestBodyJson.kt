package ru.iandreyshev.featureDreams.network.parser

import com.google.gson.annotations.SerializedName
import ru.iandreyshev.featureDreams.network.request.SaveRequest

class SaveRequestBodyJson(request: SaveRequest) {
    @SerializedName("description")
    val description: String = request.description
    @SerializedName("is_lucid")
    val IsLucid: Boolean = request.isLucid
    @SerializedName("sleeping_date")
    val sleepingDate: Long = request.sleepingDate
}