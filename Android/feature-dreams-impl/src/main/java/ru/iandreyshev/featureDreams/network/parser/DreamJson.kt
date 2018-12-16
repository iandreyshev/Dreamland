package ru.iandreyshev.featureDreams.network.parser

import com.google.gson.annotations.SerializedName

data class DreamJson(
        @SerializedName("id")
        val id: Long,
        @SerializedName("description")
        val description: String,
        @SerializedName("sleeping_date")
        val sleepingDate: Long,
        @SerializedName("is_lucid")
        val isLucid: Boolean
)