package ru.iandreyshev.coreNetwork.account.gson

import com.google.gson.annotations.SerializedName

data class AccountGson(
        @SerializedName("id")
        val id: Long,
        @SerializedName("full_name")
        val fullName: String,
        @SerializedName("avatar_url")
        val avatarUrl: String
)
