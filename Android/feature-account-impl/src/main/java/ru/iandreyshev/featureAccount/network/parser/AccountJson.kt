package ru.iandreyshev.featureAccount.network.parser

import com.google.gson.annotations.SerializedName

data class AccountJson(
        @SerializedName("id")
        val id: Long,
        @SerializedName("name")
        val name: String,
        @SerializedName("avatar_url")
        val avatarUrl: String
)
