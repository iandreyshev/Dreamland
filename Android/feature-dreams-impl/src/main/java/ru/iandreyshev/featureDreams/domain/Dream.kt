package ru.iandreyshev.featureDreams.domain

import ru.iandreyshev.featureDreamsApi.data.DreamIdentifier

data class Dream(
        val identifier: DreamIdentifier,
        val properties: DreamProperties
)
