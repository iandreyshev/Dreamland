package ru.iandreyshev.featureDreams.network.request

class EditRequest(
        val userId: Long,
        val userPassword: String,
        val dreamId: Long,
        val description: String,
        val isLucid: Boolean,
        val sleepingDate: Long
)