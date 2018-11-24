package ru.iandreyshev.featureDreamsApi.data

data class DreamListItem(
        val identifier: DreamIdentifier,
        val description: String,
        val date: Long,
        val durationHours: Byte,
        val durationMinutes: Byte,
        val isLucid: Boolean
)
