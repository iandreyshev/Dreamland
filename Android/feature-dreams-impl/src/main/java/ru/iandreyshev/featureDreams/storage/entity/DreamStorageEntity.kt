package ru.iandreyshev.featureDreams.storage.entity

import io.objectbox.annotation.Convert
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import ru.iandreyshev.featureDreams.storage.converter.SleepingDateConverter
import ru.iandreyshev.featureDreamsApi.domain.SleepingDate

@Entity
data class DreamStorageEntity(
        @Id(assignable = true)
        var id: Long = 0,
        @Convert(converter = SleepingDateConverter::class, dbType = Long::class)
        var date: SleepingDate? = null,
        var description: String = "",
        var isLucid: Boolean = false
)
