package ru.iandreyshev.featureDreams.network.request

data class DeleteDreamRequest(
        val userId: Long,
        val userPassword: String,
        val id: Long
)