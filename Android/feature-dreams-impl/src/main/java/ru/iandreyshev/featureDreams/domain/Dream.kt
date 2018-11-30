package ru.iandreyshev.featureDreams.domain

import ru.iandreyshev.featureDreamsApi.data.DreamKey

data class Dream(
        val key: DreamKey,
        val properties: DreamProperties
)
