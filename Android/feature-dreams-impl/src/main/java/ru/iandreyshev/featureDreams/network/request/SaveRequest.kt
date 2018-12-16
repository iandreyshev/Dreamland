package ru.iandreyshev.featureDreams.network.request

data class SaveRequest(
        val userId: Long,
        val userPassword: String,
        val description: String,
        val isLucid: Boolean,
        val sleepingDate: Long
)