package ru.iandreyshev.featureDreams.storage.converter

import io.objectbox.converter.PropertyConverter
import ru.iandreyshev.featureDreams.domain.SleepingDuration

class SleepingDurationConverter : PropertyConverter<SleepingDuration, Int> {

    override fun convertToDatabaseValue(entityProperty: SleepingDuration?): Int {
        return 0
    }

    override fun convertToEntityProperty(databaseValue: Int?): SleepingDuration {
        return SleepingDuration(0)
    }

}