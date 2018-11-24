package ru.iandreyshev.featureDreams.storage.converter

import io.objectbox.converter.PropertyConverter
import ru.iandreyshev.featureDreams.domain.DreamSyncState

class SyncStateConverter : PropertyConverter<DreamSyncState, Int> {

    private val mValues = DreamSyncState.values()

    override fun convertToDatabaseValue(entityProperty: DreamSyncState?): Int =
            entityProperty?.ordinal ?: DreamSyncState.WAIT.ordinal

    override fun convertToEntityProperty(databaseValue: Int?): DreamSyncState =
            mValues[databaseValue ?: DreamSyncState.WAIT.ordinal]

}