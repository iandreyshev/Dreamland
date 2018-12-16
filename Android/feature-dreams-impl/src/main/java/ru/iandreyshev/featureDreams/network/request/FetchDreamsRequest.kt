package ru.iandreyshev.featureDreams.network.request

data class FetchDreamsRequest(
        val userId: Long,
        val userPassword: String
)