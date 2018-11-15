package ru.iandreyshev.featureAccount.network.parser

import com.google.gson.annotations.SerializedName

data class AccountGson(
        @SerializedName("id")
        val id: Long,
        @SerializedName("full_name")
        val fullName: String,
        @SerializedName("avatar_url")
        val avatarUrl: String
)
