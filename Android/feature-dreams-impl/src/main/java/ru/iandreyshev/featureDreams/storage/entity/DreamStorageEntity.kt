package ru.iandreyshev.featureDreams.storage.entity

import io.objectbox.annotation.Convert
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import ru.iandreyshev.featureDreams.storage.converter.SleepingDateConverter
import ru.iandreyshev.featureDreams.storage.converter.SleepingDurationConverter
import ru.iandreyshev.featureDreams.storage.converter.SyncStateConverter
import ru.iandreyshev.featureDreams.domain.DreamSyncState
import ru.iandreyshev.featureDreams.domain.SleepingDuration
import ru.iandreyshev.featureDreamsApi.domain.SleepingDate

@Entity
data class DreamStorageEntity(
        @Id
        var id: Long = 0,

        var remoteId: Long? = null,

        @Convert(converter = SyncStateConverter::class, dbType = Int::class)
        var syncState: DreamSyncState = DreamSyncState.WAIT,

        @Convert(converter = SleepingDateConverter::class, dbType = Long::class)
        var date: SleepingDate? = null,

        @Convert(converter = SleepingDurationConverter::class, dbType = Int::class)
        var duration: SleepingDuration? = null,

        var description: String = "",
        var idLucid: Boolean = false
)
