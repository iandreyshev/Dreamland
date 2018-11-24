package ru.iandreyshev.featureDreams.domain

data class DreamProperties(
        val description: String,
        val date: SleepingDate,
        val duration: SleepingDuration,
        val isLucid: Boolean
)
