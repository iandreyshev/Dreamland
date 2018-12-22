package ru.iandreyshev.featureDreams.network.parser

import com.google.gson.annotations.SerializedName
import ru.iandreyshev.featureDreams.network.request.EditRequest

class EditRequestBodyJson(request: EditRequest) {
    @SerializedName("id")
    val dreamId: Long = request.dreamId
    @SerializedName("description")
    val description: String = request.description
    @SerializedName("is_lucid")
    val IsLucid: Boolean = request.isLucid
    @SerializedName("sleeping_date")
    val sleepingDate: Long = request.sleepingDate
}