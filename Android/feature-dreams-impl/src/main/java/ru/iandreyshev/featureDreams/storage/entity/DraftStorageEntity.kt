package ru.iandreyshev.featureDreams.storage.entity

import io.objectbox.annotation.Id

data class DraftStorageEntity(
        @Id val id: Long = 0,
        val description: String = ""
)
